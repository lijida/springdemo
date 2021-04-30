package com.wrapping.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class TestBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("userService")){
            System.out.println("userService实例化后");
        }
        return true;
    }
    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        if(beanName.equals("userService1")){
            Object o= Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("代理逻辑");
                    method.invoke(bean,args);
                    return null;
                }
            });
            return o;
        }
        return  bean;
    }
}
