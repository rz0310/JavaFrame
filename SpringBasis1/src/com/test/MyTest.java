package com.test;

import com.bean.Dog;
import com.bean.Student;
import com.beanfactory.BeanFactory;
import com.studentdao.StudentDao;
import com.studentdao.imp.StudentDaoImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void mytest(){
//        ConfigurableApplicationContext:让AllicationContext具有刷新（refresh()）和关闭(close())功能，是AllicationContext的扩展。
        ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentdao = (StudentDao) context.getBean("studentdao");
        studentdao.study("任静");
    }
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImp();
        studentDao.study("renjing");
    }
    @Test
    public void mytest2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Student student = (Student) context.getBean("student2");
        System.out.println(student);
    }
    @Test
    public void mytest3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Student student = (Student) context.getBean("student3");
        System.out.println(student);
    }
    @Test
    public void mytest4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Student student = (Student) context.getBean("student4");
        System.out.println(student);
    }
    @Test
    public void testFactory(){
        Dog bean = BeanFactory.getBean();
        System.out.println(bean);
    }
    @Test
    public void testFactory1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog dogbean = (Dog) context.getBean("dogfactory");
        System.out.println(dogbean);
    }
    @Test
    public void testFactory2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog dogbean = (Dog) context.getBean("factorybean");
        System.out.println(dogbean);
    }
}
