package com.wrapping;

import com.wrapping.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class WrapApplication {
    public static void main(String[] args) {
        //SpringApplication.run(WrapApplication.class,args);
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        UserService userService=applicationContext.getBean("userService",UserService.class);
        userService.test();

    }
}
