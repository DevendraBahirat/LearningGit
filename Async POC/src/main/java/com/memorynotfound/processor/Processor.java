/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound.processor;

import com.memorynotfound.response.Response;

/**
 *
 * @author Devendra Bahirat
 */
public interface Processor<T extends Response> {
    T process();
    Boolean isMoreDataRequired();
}
