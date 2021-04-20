package com.wrapping.annotation;

import java.lang.annotation.*;

@Target( {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseBodyModel {
    boolean encrypt() default true;
}
