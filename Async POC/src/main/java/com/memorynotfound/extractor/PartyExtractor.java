/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.extractor;

import com.memorynotfound.response.PartyExtractorResponse;
import com.memorynotfound.response.ResponseManager;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class PartyExtractor implements Extractor<PartyExtractorResponse> {

    private Boolean isMoreDataRequired = false;

    @Override
    public Boolean isMoreDataRequired() {
        return this.isMoreDataRequired;
    }

    public void setIsMoreDataRequired(Boolean isMoreDataRequired) {
        this.isMoreDataRequired = isMoreDataRequired;
    }

    @Override
    @Async
    public Future<PartyExtractorResponse> extract() {
        try {
            System.out.println("Extracting PartyExtractorResponse");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PartyExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Extracted PartyExtractorResponse");
        return new AsyncResult<>(new PartyExtractorResponse());
    }

    @Override
    public void populateRequiredData(ResponseManager responseManager) {
        System.out.println("Populated data for extractor " + this);
    }
}
