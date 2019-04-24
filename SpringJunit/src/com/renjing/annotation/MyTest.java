package com.renjing.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//设置注解的生命周期
@Target(ElementType.METHOD)//设置注解作用的对象
public @interface MyTest {

}
