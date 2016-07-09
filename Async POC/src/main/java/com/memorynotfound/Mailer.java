/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorynotfound;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Devendra Bahirat
 */
@Component
public class Mailer {
    
    @Autowired
    MailSender mailSender;
    
    List<MailSender> mailerList = new ArrayList();

    public void setMailer(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void sendMail() throws InterruptedException {
        for(int i=0; i<4; i++) {
            mailerList.add(mailSender);
        }
        System.out.println("Mailer");
        System.out.println("Mailer about to run");
        for(MailSender sender : mailerList) {
            sender.sendMail();
        }
        System.out.println("Mailer this will run immediately.");
    }
}
