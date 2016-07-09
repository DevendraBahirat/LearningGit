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
public class PhoneProcessorResponse implements Response {
    
    private Long phoneNumber;

    public PhoneProcessorResponse(Long phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
