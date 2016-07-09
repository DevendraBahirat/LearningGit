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
public class AccountExtractorResponse implements Response {
    private Long accountId;

    public AccountExtractorResponse() {
        this.accountId = 1234L;
    }
    
    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
