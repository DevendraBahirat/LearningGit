package com.memorynotfound;

import com.memorynotfound.extractor.Extractor;
import com.memorynotfound.manager.ExtractorBeanManager;
import com.memorynotfound.manager.InvocationManager;
import com.memorynotfound.processor.DeviceProcessor;
import com.memorynotfound.processor.PhoneProcessor;
import com.memorynotfound.processor.Processor;
import com.memorynotfound.response.CompleteResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String... args) throws InterruptedException, ExecutionException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mailer mailer = context.getBean(Mailer.class);
        
        /**
        * creating new object causes 
        * the async method to run in main thread
        * making them sequential.
        **/
//        MailSender mailSender = new MailSender();
//        mailer.setMailer(mailSender);
//        System.out.println("about to run");
//        mailer.sendMail();
//        System.out.println("this will run immediately.");
//        System.out.println("mail send result: ");//+ result);
        

        /**
         * Invocation Manager to invoke processors o extractors
         */
        InvocationManager invocationManager = context.getBean(InvocationManager.class);
        /**
         * ExtractorBeanManager to hold beans of extractors as we cannot create extractors using new()
         */
        ExtractorBeanManager extractorBeanManager = context.getBean(ExtractorBeanManager.class);
        
        /**
         * fetching extractors
         */
        List<Extractor> extractors = new ArrayList();
        extractors.add(extractorBeanManager.getAccountExtractor());
        extractors.add(extractorBeanManager.getPartyExtractor());
        
        /**
         * preparing processors
         */
        List<Processor> processors = new ArrayList();
        DeviceProcessor deviceProcessor = new DeviceProcessor(null, null, Boolean.TRUE);
        PhoneProcessor phoneProcessor = new PhoneProcessor(null,Boolean.TRUE);
        processors.add(deviceProcessor);
        processors.add(phoneProcessor);
        
        /**
         * feeding extractors and processors and then invoking them.
         */
        Long strtTime = System.currentTimeMillis();
        CompleteResponse response = invocationManager.setExtractors(extractors).setProcessors(processors).invoke();
        Long endTime = System.currentTimeMillis();
        System.out.println("Execution Time : " + (endTime-strtTime));
        System.out.println("Response : " + response.toString());
    }
}
