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
    
    public Map<String, Response> getResponsesMap() {
        return responsesMap;
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
        CompleteResponse completeResponse = new CompleteResponse();
        completeResponse.setAccountResponse((AccountExtractorResponse) responsesMap.get(AccountExtractorResponse.class.getSimpleName()));
        completeResponse.setDeviceResponse((DeviceProcessorResponse) responsesMap.get(DeviceProcessorResponse.class.getSimpleName()));
        completeResponse.setPartyResponse((PartyExtractorResponse) responsesMap.get(PartyExtractorResponse.class.getSimpleName()));
        completeResponse.setPhoneResponse((PhoneProcessorResponse) responsesMap.get(PhoneProcessorResponse.class.getSimpleName()));
        return completeResponse;
    }
}
