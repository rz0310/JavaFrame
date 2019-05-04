package com.renjing.ui;

import com.renjing.service.ICustomerService;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ICustomerService customerService = (ICustomerService) ac.getBean("customerService");
        customerService.saveCustomer();
    }
}
