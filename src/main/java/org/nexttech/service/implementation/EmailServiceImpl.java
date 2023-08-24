//package org.nexttech.service.implementation;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailServiceImpl {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    public void sendSimpleMessage() {
//        String to = "joitarazvan@yahoo.com";
//        String subject = "Test Email";
//        String text = "This is a test email sent using Spring Boot and JavaMailSender.";
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("joitarazvan@yahoo.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//
//        emailSender.send(message);
//    }
//}
