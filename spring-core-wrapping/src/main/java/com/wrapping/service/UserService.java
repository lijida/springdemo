package com.wrapping.service;

import com.wrapping.mapper.UserMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean,UserInterface{
   // private UserMapper userMapper;

    private User user;

    public UserService(){
        System.out.println("构造方法");
    }
    @Autowired
    public void setUser(User user){
        System.out.println("set方法注入");
        this.user=user;
    }
    @PostConstruct
    public void xxx(){
        System.out.println("XXX");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this);
        System.out.println("初始化");
    }

    @Override
    public void test() {
        System.out.println("业务逻辑");
       // System.out.println(userMapper.getById());
    }
}
