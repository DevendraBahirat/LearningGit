/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.manager;

import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.processor.Processor;
import com.memorynotfound.response.CompleteResponse;
import com.memorynotfound.response.DataPropagator;
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

    List<Extractor> extractors = new ArrayList<>();
    Map<Integer, List<Processor>> processorsMap = new HashMap();
    Map<Integer, List<Extractor>> extractorsMap = new ConcurrentHashMap<>();

    @Autowired
    private ResponseManager responseManager;
    @Autowired
    private DataPropagator dataPropagator;

    public InvocationManager setProcessors(List<Processor> processors) {
        this.processorsMap.put(counter++, processors);
        return this;
    }

    public InvocationManager setExtractors(List<Extractor> extractors) {
        this.extractorsMap.put(counter++, extractors);
        this.extractors.addAll(extractors);
        return this;
    }

    public CompleteResponse invoke() {
        for (int i = 0; i < counter; i++) {
            System.out.println("about to start " + i + " iteration");
            responseManager.manageRespones(responses);
            if (processorsMap.get(i) != null) {
                for (Processor processor : processorsMap.get(i)) {
                    if (processor.isMoreDataRequired()) {
                        System.out.println("populate data for processor " + processor);
                        dataPropagator.populateDataForProcessors(processor, responseManager);
                    }
                    responses.add(processor.process());
                    responseManager.manageRespones(responses);
                }
            } else if (extractorsMap.get(i) != null) {
                List<Future<Response>> tempResponses = new ArrayList<>();
                for (Extractor extractor : extractorsMap.get(i)) {
                    if (extractor.isMoreDataRequired()) {
                        System.out.println("populate data for extractor " + extractor);
                        dataPropagator.populateDataForExtractors(extractor, responseManager);
                    }
                    System.out.println("Exceuting extractor " + extractor);
                    tempResponses.add(extractor.extract());
                    System.out.println("Preparing Next extractor ");
                }
                addToResponseList(tempResponses);
                responseManager.manageRespones(responses);
            }
        }
        return responseManager.getCompleteResponse();
    }

    private void addToResponseList(List<Future<Response>> tempResponses) {
        try {
            System.out.println("waiting for List to realise");
            for (Future<Response> future : tempResponses) {
                responses.add(future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(InvocationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void invokeExtractors() {
        for (Extractor extractor : extractors) {
//            if (extractor.isMoreDataRequired()) {
//                System.out.println("populate data for extractor " + extractor);
//                dataPropagator.populateDataForExtractors(extractor, responseManager);
//            }
            System.out.println("Exceuting extractor " + extractor);
            extractor.extract();
            System.out.println("Preparing Next extractor ");
        }
    }
}
