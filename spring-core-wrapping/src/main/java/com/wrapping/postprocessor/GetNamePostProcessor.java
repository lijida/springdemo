package com.wrapping.postprocessor;

import com.wrapping.annotation.SetValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
@Component
public class GetNamePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz=bean.getClass();
        for(Field field:clazz.getDeclaredFields()){
           if(field.isAnnotationPresent(SetValue.class)){
               SetValue fieldAnnotation=field.getAnnotation(SetValue.class);
               String value=fieldAnnotation.value();
               ReflectionUtils.makeAccessible(field);
               try {
                   field.set(bean,value);
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }

        }
        return bean;
    }

}
