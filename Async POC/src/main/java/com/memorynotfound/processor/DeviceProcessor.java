/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.processor;

import com.memorynotfound.response.AccountExtractorResponse;
import com.memorynotfound.response.DeviceProcessorResponse;
import com.memorynotfound.response.PartyExtractorResponse;
import com.memorynotfound.response.Response;
import com.memorynotfound.response.ResponseManager;
import java.util.Map;

/**
 *
 * @author Devendra Bahirat
 */
public class DeviceProcessor implements Processor {

    private Long accountId;
    private Long partyId;
    private Boolean isMoreDataRequired;

    public DeviceProcessor(Long accountId, Long partyId, Boolean isMoreDataRequired) {
        this.accountId = accountId;
        this.partyId = partyId;
        this.isMoreDataRequired = isMoreDataRequired;
    }

    @Override
    public DeviceProcessorResponse process() {
        return new DeviceProcessorResponse(accountId + partyId);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public void setIsMoreDataRequired(Boolean isMoreDataRequired) {
        this.isMoreDataRequired = isMoreDataRequired;
    }

    @Override
    public Boolean isMoreDataRequired() {
        return this.isMoreDataRequired;
    }

    @Override
    public void populateRequiredData(ResponseManager responseManager) {
        System.out.println("Populated data for processor " + this);
        Map<String, Response> responsesMap = responseManager.getResponsesMap();
        if (this.accountId == null) {
            if (responsesMap.containsKey(AccountExtractorResponse.class.getSimpleName())) {
                AccountExtractorResponse accountResponse = (AccountExtractorResponse) responsesMap.get(AccountExtractorResponse.class.getSimpleName());
                this.accountId = accountResponse.getAccountId();
            }
        }
        if (this.partyId == null) {
            if (responsesMap.containsKey(PartyExtractorResponse.class.getSimpleName())) {
                PartyExtractorResponse partyResponse = (PartyExtractorResponse) responsesMap.get(PartyExtractorResponse.class.getSimpleName());
                this.partyId = partyResponse.getPartyId();
            }
        }
    }
}
