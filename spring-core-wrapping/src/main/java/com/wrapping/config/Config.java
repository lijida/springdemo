package com.wrapping.config;

import com.wrapping.service.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wrapping")
public class Config {
    @Bean
    public User user(){
        User user=new User();
        return  user;
    }
}
