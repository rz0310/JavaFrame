package com.renjing.ui;

import com.renjing.service.ICustomerService;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ICustomerService customerService = (ICustomerService) context.getBean("ICustomerServiceImp");
//        ICustomerService customerService2 = (ICustomerService) context.getBean("ICustomerServiceImp");
//        ICustomerService customerService = (ICustomerService) context.getBean("staticCustomerService");
//        ICustomerService customerService = (ICustomerService) context.getBean("InstanceCustomerService");
        customerService.saveCustomer();
//        context.close();
//        System.out.println(customerService==customerService2);
    }
    @Test
    public void test(){
        ClassPathResource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        ICustomerService customerService = (ICustomerService) factory.getBean("ICustomerServiceImp");
        customerService.saveCustomer();
    }
}
