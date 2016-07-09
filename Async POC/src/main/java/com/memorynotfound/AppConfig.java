package com.memorynotfound;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan("com.memorynotfound")
public class AppConfig {// implements AsyncConfigurer {

//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(7);
//        executor.setMaxPoolSize(42);
//        executor.setQueueCapacity(11);
//        executor.setThreadNamePrefix("MyExecutor-");
//        executor.initialize();
//        return executor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return new AsyncUncaughtExceptionHandler() {
//            @Override
//            public void handleUncaughtException(Throwable thrwbl, Method method, Object... os) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        };
//    }

}
