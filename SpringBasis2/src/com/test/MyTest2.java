package com.test;

import com.servicedao.StudentServiceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest2 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        StudentServiceDao studentServiceDao = (StudentServiceDao) context.getBean("studentServiceDaoImp");
        studentServiceDao.showStu();
    }
}
