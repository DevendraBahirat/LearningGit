/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.manager;

import com.memorynotfound.extractor.Extractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class ExtractorBeanManager {

    @Autowired
    @Qualifier("accountExtractor")
    Extractor accountExtractor;
    
    @Autowired
    @Qualifier("partyExtractor")
    Extractor partyExtractor;

    public Extractor getAccountExtractor() {
        return accountExtractor;
    }

    public Extractor getPartyExtractor() {
        return partyExtractor;
    }
}
