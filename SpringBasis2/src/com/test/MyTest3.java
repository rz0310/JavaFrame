package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
//@PropertySource(value = {"classpath:com/demo.properties"})//当配置文件放在src的com包下
@PropertySource(value = {"classpath:demo.properties"})//当配置文件放在src下时
public class MyTest3 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        String name = context.getEnvironment().getProperty("name");
        System.out.println(name);
    }
}
