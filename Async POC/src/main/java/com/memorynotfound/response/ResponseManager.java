/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.response;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class ResponseManager {

    AccountExtractorResponse accountExtractorResponse;
    PartyExtractorResponse partyExtractorResponse;
    DeviceProcessorResponse deviceProcessorResponse;
    PhoneProcessorResponse phoneProcessorResponse;

    public AccountExtractorResponse getAccountExtractorResponse() {
        return accountExtractorResponse;
    }

    public void setAccountExtractorResponse(AccountExtractorResponse accountExtractorResponse) {
        this.accountExtractorResponse = accountExtractorResponse;
    }

    public PartyExtractorResponse getPartyExtractorResponse() {
        return partyExtractorResponse;
    }

    public void setPartyExtractorResponse(PartyExtractorResponse partyExtractorResponse) {
        this.partyExtractorResponse = partyExtractorResponse;
    }

    public DeviceProcessorResponse getDeviceProcessorResponse() {
        return deviceProcessorResponse;
    }

    public void setDeviceProcessorResponse(DeviceProcessorResponse deviceProcessorResponse) {
        this.deviceProcessorResponse = deviceProcessorResponse;
    }

    public PhoneProcessorResponse getPhoneProcessorResponse() {
        return phoneProcessorResponse;
    }

    public void setPhoneProcessorResponse(PhoneProcessorResponse phoneProcessorResponse) {
        this.phoneProcessorResponse = phoneProcessorResponse;
    }

    public void manageRespones(List<Response> responses) {
        System.out.println("managing responses");
        if (!responses.isEmpty()) {
            for (Response response : responses) {
                switch (response.getClass().getSimpleName()) {
                    case "AccountExtractorResponse":
                        accountExtractorResponse = (AccountExtractorResponse) response;
                        break;
                    case "PartyExtractorResponse":
                        partyExtractorResponse = (PartyExtractorResponse) response;
                        break;
                    case "DeviceProcessorResponse":
                        deviceProcessorResponse = (DeviceProcessorResponse) response;
                        break;
                    case "PhoneProcessorResponse":
                        phoneProcessorResponse = (PhoneProcessorResponse) response;
                        break;
                }
            }
        }
    }

    public CompleteResponse getCompleteResponse() {
        return new CompleteResponse(accountExtractorResponse, deviceProcessorResponse, partyExtractorResponse, phoneProcessorResponse);
    }
}
