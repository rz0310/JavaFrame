package com.test;

import com.config.SpringConfig;
import com.dao.CustomerDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
//    private static final Object SpringConfig = 1l;

    @Test
    public void test1() throws ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Class.forName("SpringConfig"));
    }
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        customerDao.save();
    }
    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        System.out.println(customerDao);
    }
//    @Test
//    public void test4(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
//        System.out.println(customerDao);
//    }
}
