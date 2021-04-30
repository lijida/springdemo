package com.wrapping;


import com.wrapping.config.Config;
import com.wrapping.service.User;
import com.wrapping.service.UserInterface;
import com.wrapping.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
       // beanFactory.registerSingleton("user",new User());

       // ClassPathXmlApplicationContext xmlApplicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Config.class);

       // AbstractBeanDefinition beanDefinition= BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        //beanDefinition.setBeanClass(User.class);

        //beanFactory.registerBeanDefinition("user",beanDefinition);
        //User user=beanFactory.getBean("user",User.class);
       // annotationConfigApplicationContext.registerBeanDefinition("user",beanDefinition);
       // annotationConfigApplicationContext.refresh();
      //  User user=annotationConfigApplicationContext.getBean("user",User.class);


       // System.out.println(annotationConfigApplicationContext.getEnvironment().getSystemEnvironment());

       // user.test();

        //System.out.println(user);
        UserInterface userInterface= (UserInterface) annotationConfigApplicationContext.getBean("userService");
        userInterface.test();
    }
}
