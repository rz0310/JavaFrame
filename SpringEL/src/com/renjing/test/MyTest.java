package com.renjing.test;

import com.renjing.dao.CarDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CarDao carDaoImp = (CarDao) context.getBean("carDaoImp");
        carDaoImp.show();
    }
}
