/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.manager;

import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.processor.Processor;
import com.memorynotfound.response.CompleteResponse;
import java.util.List;

/**
 *
 * @author Devendra Bahirat
 */
public interface Invocation {

    InvocationManager setProcessors(List<Processor> processors);

    InvocationManager setExtractors(List<Extractor> extractors);

    CompleteResponse invoke();
    
    void clearPreviousInvocationData();

}
