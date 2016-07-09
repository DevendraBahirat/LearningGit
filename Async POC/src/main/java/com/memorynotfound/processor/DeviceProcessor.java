/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.processor;

import com.memorynotfound.response.DeviceProcessorResponse;

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
        return new DeviceProcessorResponse(accountId+partyId);
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
}