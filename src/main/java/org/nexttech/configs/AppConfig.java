//package org.nexttech.configs;
//
//
//import org.nexttech.controller.StudentRestController;
//import org.nexttech.mapping.MapperInterface;
//import org.nexttech.mapping.MapperInterfaceImpl;
//import org.nexttech.repos.interfaces.StudentRepositoryDB;
//import org.nexttech.service.implementation.StudentService;
//import org.nexttech.service.interfaces.IService;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
////    @Bean
////    public StudentRepositoryDB studentRepository() {
////        return new StudentRepositoryDB();
////    }
//
//    @Bean
//    public MapperInterface mapperInterface() {
//        return new MapperInterfaceImpl();
//    }
//
//    @Bean
//    public IService studentService() {
//        return new StudentService(studentRepository(), mapperInterface());
//    }
//
//    @Bean
//    public StudentRestController studentController() {
//        return new StudentRestController(studentService());
//    }
//
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory() {
//        return new TomcatServletWebServerFactory();
//    }
//
//    @Bean
//    public MapperInterface mapper() {
//        return new MapperInterfaceImpl();
//    }
//}
