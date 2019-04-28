package com.renjing.ui;

import com.renjing.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService customerService = (ICustomerService) ac.getBean("customerService");
        customerService.saveCustomer();;
    }
}
