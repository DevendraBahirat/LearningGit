/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.extractor;

import com.memorynotfound.response.AccountExtractorResponse;
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
public class AccountExtractor implements Extractor<AccountExtractorResponse> {

    private Boolean isMoreDataRequired = Boolean.FALSE;

    @Override
    @Async
    public Future<AccountExtractorResponse> extract() {
        try {
            System.out.println("Extracting AccountExtractorResponse");
            System.out.println("Thread Name : " + Thread.currentThread().getName());
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Extracted AccountExtractorResponse");
        return new AsyncResult<>(new AccountExtractorResponse());
    }

    @Override
    public Boolean isMoreDataRequired() {
        return this.isMoreDataRequired;
    }

    public AccountExtractor setIsMoreDataRequired(Boolean isMoreDataRequired) {
        this.isMoreDataRequired = isMoreDataRequired;
        return this;
    }

    @Override
    public void populateRequiredData(ResponseManager responseManager) {
        System.out.println("Populated data for extractor " + this);
    }
}
