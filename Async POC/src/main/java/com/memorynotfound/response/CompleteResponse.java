/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.response;

/**
 *
 * @author Devendra Bahirat
 */
public class CompleteResponse implements Response{
    AccountExtractorResponse accountResponse;
    DeviceProcessorResponse deviceResponse;
    PartyExtractorResponse partyResponse;
    PhoneProcessorResponse phoneResponse;

    public CompleteResponse(AccountExtractorResponse accountResponse, DeviceProcessorResponse deviceResponse, PartyExtractorResponse partyResponse, PhoneProcessorResponse phoneResponse) {
        this.accountResponse = accountResponse;
        this.deviceResponse = deviceResponse;
        this.partyResponse = partyResponse;
        this.phoneResponse = phoneResponse;
    }

    public AccountExtractorResponse getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(AccountExtractorResponse accountResponse) {
        this.accountResponse = accountResponse;
    }

    public DeviceProcessorResponse getDeviceResponse() {
        return deviceResponse;
    }

    public void setDeviceResponse(DeviceProcessorResponse deviceResponse) {
        this.deviceResponse = deviceResponse;
    }

    public PartyExtractorResponse getPartyResponse() {
        return partyResponse;
    }

    public void setPartyResponse(PartyExtractorResponse partyResponse) {
        this.partyResponse = partyResponse;
    }

    public PhoneProcessorResponse getPhoneResponse() {
        return phoneResponse;
    }

    public void setPhoneResponse(PhoneProcessorResponse phoneResponse) {
        this.phoneResponse = phoneResponse;
    }
    
    
}
