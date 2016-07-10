/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.extractor;

import com.memorynotfound.response.Response;
import com.memorynotfound.response.ResponseManager;
import java.util.concurrent.Future;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 * @param <T>
 */
@Component
public interface Extractor<T extends Response> {
    Future<T> extract();
    Boolean isMoreDataRequired();
    void populateRequiredData(ResponseManager responseManager);
}
