/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.response;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class ResponseManager {

    private final Map<String, Response> responsesMap = new ConcurrentHashMap<>();
    
    public AccountExtractorResponse getAccountExtractorResponse() {
        return (AccountExtractorResponse) responsesMap.get(AccountExtractorResponse.class.getSimpleName());
    }

    public PartyExtractorResponse getPartyExtractorResponse() {
        return (PartyExtractorResponse) responsesMap.get(PartyExtractorResponse.class.getSimpleName());
    }

    public DeviceProcessorResponse getDeviceProcessorResponse() {
        return (DeviceProcessorResponse) responsesMap.get(DeviceProcessorResponse.class.getSimpleName());
    }

    public PhoneProcessorResponse getPhoneProcessorResponse() {
        return (PhoneProcessorResponse) responsesMap.get(PhoneProcessorResponse.class.getSimpleName());
    }

    public void manageRespones(List<Response> responses) {
        System.out.println("managing responses");
        if (!responses.isEmpty()) {
            for (Response response : responses) {
                responsesMap.put(response.getClass().getSimpleName(), response);
            }
        }
    }

    public CompleteResponse getCompleteResponse() {
        CompleteResponse completeResponse = new CompleteResponse(getAccountExtractorResponse(), getDeviceProcessorResponse(), getPartyExtractorResponse(), getPhoneProcessorResponse());
        return completeResponse;
    }
}
