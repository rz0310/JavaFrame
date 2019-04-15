package com.renjing.ui;

import com.renjing.service.ICustomerService;
import com.renjing.service.ICustomerService2;
import com.renjing.service.ICustomerService3;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

//模拟一个表现层
public class Client {

//    Bean创建的两种规则：
//    BeanFactory：提供的是一种延迟加载的思想来创建对象。Bean对象什么时候用什么时候创建
//    ApplicationContext：提供的是一种立即加载的思想来创建Bean对象。只要一解析完配置文件，
//    就立马创建对象

    public static void main(String[] args) {
//        1.创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        2.根据bean的id获取容器
//        ICustomerService customerService = (ICustomerService) context.getBean("ICustomerService");
//        customerService.saveCustomer();
//        ICustomerService2 customerService2 = (ICustomerService2) context.getBean("ICustomerService2");
//        customerService2.saveCustomer();
        ICustomerService3 customerService3 = (ICustomerService3) context.getBean("ICustomerService3");
        customerService3.saveCustomer();
    }
}
