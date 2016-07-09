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
public class PartyExtractorResponse implements Response {
    private Long partyId;

    public PartyExtractorResponse() {
        this.partyId = 789L;
    }

    public Long getPartyId() {
        return this.partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

}
