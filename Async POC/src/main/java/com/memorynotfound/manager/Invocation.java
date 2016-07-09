/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.manager;

import com.memorynotfound.manager.InvocationManager;
import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.processor.Processor;
import com.memorynotfound.response.CompleteResponse;
import java.util.List;

/**
 *
 * @author Devendra Bahirat
 */
public interface Invocation {

    public InvocationManager setProcessors(List<Processor> processors);

    public InvocationManager setExtractors(List<Extractor> extractors);

    public CompleteResponse invoke();

    public void invokeExtractors();
}
