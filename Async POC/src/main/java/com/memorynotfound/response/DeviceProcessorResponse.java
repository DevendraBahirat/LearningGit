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
public class DeviceProcessorResponse implements Response {
    
    public Long deviceId;

    public DeviceProcessorResponse(Long deviceId) {
        this.deviceId = 4521L;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "DeviceProcessorResponse{" + "deviceId=" + deviceId + '}';
    }
    
}
