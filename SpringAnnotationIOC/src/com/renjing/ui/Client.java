package com.renjing.ui;

import com.renjing.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml", SpringConfiguration.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("config/bean.xml");//参数为包名全路径
        ICustomerService customerService = (ICustomerService) context.getBean("customerService");
        System.out.println(customerService);
        ICustomerService customerService2 = (ICustomerService) context.getBean("customerService");
        customerService.saveCustomer();
        System.out.println(customerService==customerService2);
    }
}
