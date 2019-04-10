package com.test;

import com.bean.Car;
import com.bean.JiaoCar;
import com.bean.Student;
import com.dao.StudentGradeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JiaoCar jiaocar = (JiaoCar) context.getBean("jiaocar");
        System.out.println(jiaocar);
    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car) context.getBean("car2");
        System.out.println(car);
    }
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
//        Student student = (Student) context.getBean("student");
//        StudentGradeDao studentGradeDao = new StudentDaoImp();
//        studentGradeDao.getGrade(student);
        StudentGradeDao studentDao = (StudentGradeDao) context.getBean("studentDao");
        studentDao.getGrade();
    }
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
