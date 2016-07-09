/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.response;

import com.memorynotfound.extractor.AccountExtractor;
import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.extractor.PartyExtractor;
import com.memorynotfound.processor.DeviceProcessor;
import com.memorynotfound.processor.PhoneProcessor;
import com.memorynotfound.processor.Processor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class DataPropagator {

    public void populateDataForProcessors(Processor processor, ResponseManager responseManager) {
        switch (processor.getClass().getSimpleName()) {
            case "DeviceProcessor":
                System.out.println("Populated data for processor" + processor);
                DeviceProcessor deviceProcessor = (DeviceProcessor) processor;
                if (deviceProcessor.getAccountId() == null) {
                    deviceProcessor.setAccountId(responseManager.getAccountExtractorResponse().getAccountId());
                }
                if (deviceProcessor.getPartyId() == null) {
                    deviceProcessor.setPartyId(responseManager.getPartyExtractorResponse().getPartyId());
                }
                break;
            case "PhoneProcessor":
                System.out.println("Populated data for processor " + processor);
                PhoneProcessor phoneProcessor = (PhoneProcessor) processor;
                if (phoneProcessor.getDeviceId() == null) {
                    phoneProcessor.setDeviceId(responseManager.getDeviceProcessorResponse().getDeviceId());
                }
                break;
        }
    }

    public void populateDataForExtractors(Extractor extractor,  ResponseManager responseManager) {
        switch (extractor.getClass().getSimpleName()) {

            case "AccountExtractor":
                System.out.println("Populated data for extractor " + extractor);
                AccountExtractor accountExtractor = (AccountExtractor) extractor;
                break;
            case "PartyExtractor":
                System.out.println("Populated data for extractor " + extractor);
                PartyExtractor partyExtractor = (PartyExtractor) extractor;
                break;
        }
    }
}
