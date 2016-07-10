/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.processor;

import com.memorynotfound.response.PhoneProcessorResponse;
import com.memorynotfound.response.ResponseManager;

/**
 *
 * @author Devendra Bahirat
 */
public class PhoneProcessor implements Processor<PhoneProcessorResponse> {

    private Long deviceId;
    private Boolean isMoreDataRequired;

    public PhoneProcessor(Long deviceId, Boolean isMoreDataRequired) {
        this.deviceId = deviceId;
        this.isMoreDataRequired = isMoreDataRequired;
    }

    @Override
    public PhoneProcessorResponse process() {
        return new PhoneProcessorResponse(deviceId * 1111);
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
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
        if (this.deviceId == null) {
            this.deviceId = responseManager.getDeviceProcessorResponse().getDeviceId();
        }
    }
}
