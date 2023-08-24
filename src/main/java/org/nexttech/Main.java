package org.nexttech;

//import org.nexttech.service.implementation.EmailServiceImpl;
//import org.nexttech.service.implementation.PasswordGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
//                .useLower(true)
//                .useUpper(true)
//                .useDigits(true)
//                .usePunctuation(true)
//                .build();
//
//        String generatedPassword = passwordGenerator.generate(12);
//        System.out.println("Generated Password: " + generatedPassword);
//
//        ApplicationContext context = SpringApplication.run(Main.class, args);
//        EmailServiceImpl emailService = context.getBean(EmailServiceImpl.class);
//
//        emailService.sendSimpleMessage();

//        ApplicationContext context = SpringApplication.run(Main.class, args);
//        EmailServiceImpl emailService = context.getBean(EmailServiceImpl.class);
//
//        emailService.sendSimpleMessage();

    }


}
