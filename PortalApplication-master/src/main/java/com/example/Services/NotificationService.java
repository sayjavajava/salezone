package com.example.Services;

import com.example.Domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by kamran on 4/6/2017.
 */
@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotificaitoin(user user) throws MailException, InterruptedException {

      /*  System.out.println("Sleeping now...");
        Thread.sleep(1000);

        System.out.println("Sending email...");
*/
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("waqasrana11@gmail.com");
        mail.setSubject("Registration Info");
        mail.setText("you are registered successfully with Easy Shopping application");
        javaMailSender.send(mail);

        System.out.println("Email Sent!");
    }

}