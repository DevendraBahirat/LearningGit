/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.manager;

import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.processor.Processor;
import com.memorynotfound.response.CompleteResponse;
import com.memorynotfound.response.Response;
import com.memorynotfound.response.ResponseManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class InvocationManager implements Invocation {

    Integer counter = 0;

    List<Response> responses = new ArrayList();

    Map<Integer, List<Processor>> processorsMap = new HashMap();
    Map<Integer, List<Extractor>> extractorsMap = new ConcurrentHashMap<>();

    @Autowired
    private ResponseManager responseManager;

    /**
     *
     * @param processors
     * @return
     */
    @Override
    public InvocationManager setProcessors(List<Processor> processors) {
        this.processorsMap.put(this.counter++, processors);
        return this;
    }

    /**
     *
     * @param extractors
     * @return
     */
    @Override
    public InvocationManager setExtractors(List<Extractor> extractors) {
        this.extractorsMap.put(this.counter++, extractors);
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public CompleteResponse invoke() {
        for (int i = 0; i < this.counter; i++) {
            System.out.println("about to start " + i + " iteration");
            if (this.processorsMap.get(i) != null) {
                invokeProcessors(i);
            } else if (this.extractorsMap.get(i) != null) {
                invokeExtractors(i);
            }
        }
        return this.responseManager.getCompleteResponse();
    }

    /**
     *
     */
    @Override
    public void clearPreviousInvocationData() {
        this.counter = 0;
        this.responses.clear();
        this.processorsMap.clear();
        this.extractorsMap.clear();
        this.responseManager.clearResponsesMap();
    }
    
    private void invokeExtractors(int i) {
        List<Future<Response>> tempResponses = new ArrayList<>();
        for (Extractor extractor : this.extractorsMap.get(i)) {
            if (extractor.isMoreDataRequired()) {
                System.out.println("populate data for extractor " + extractor);
                extractor.populateRequiredData(this.responseManager);
            }
            System.out.println("Exceuting extractor " + extractor);
            tempResponses.add(extractor.extract());
            System.out.println("Preparing Next extractor ");
        }
        addToResponseList(tempResponses);
        this.responseManager.manageRespones(this.responses);
    }

    private void invokeProcessors(int i) {
        for (Processor processor : this.processorsMap.get(i)) {
            if (processor.isMoreDataRequired()) {
                System.out.println("populate data for processor " + processor);
                processor.populateRequiredData(this.responseManager);
            }
            this.responses.add(processor.process());
            this.responseManager.manageRespones(this.responses);
        }
    }

    private void addToResponseList(List<Future<Response>> tempResponses) {
        try {
            System.out.println("waiting for List to realise");
            for (Future<Response> future : tempResponses) {
                this.responses.add(future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(InvocationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
