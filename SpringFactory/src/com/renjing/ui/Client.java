package com.renjing.ui;

import com.renjing.dao.ICustomerDao;
import com.renjing.factory.BeanFactory;
import com.renjing.service.ICustomerService;
import com.renjing.service.imp.ICustomerServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//模拟一个表现层
public class Client {
    public static void main(String[] args) {
//        ICustomerService customerService = (ICustomerService)BeanFactory.getBean("CUSTOMERSERVICE");
//        customerService.saveCustomer();
//        for (int i = 0; i < 5; i++) {
//            ICustomerService customerService = (ICustomerService)BeanFactory.getBean("CUSTOMERSERVICE");
//            customerService.saveCustomer();
//        }
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService iCustomerServiceImp = (ICustomerService) context.getBean("iCustomerServiceImp");
        iCustomerServiceImp.saveCustomer();
    }
}
