package com.renjing.test;

import com.renjing.bean.Student;
import com.renjing.service.IStudentService;
import config.SpringConfigration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
测试客户的业务层
Spring郑和Junit：
（1）拷贝Spring提供的整合jar包：spring-test-4.2.4.RELEASE.jar
（2）使用Junit提供的一个注解，把原有的main函数替换掉，换成Spring提供的
    @RunWith  要换的类：SpringJunit4ClassRunner
（3）使用spring提供的注解告诉Spring，配置文件或者注解类所在的位置：@ContextConfiguration
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigration.class})
public class StudentServiceTest {
    @Autowired//自动装配
    private IStudentService studentService = null;
    @Test
    public void testFindAllStudent(){
        List<Student> list = studentService.findAllStudent();
        for (Student s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void testSaveStudent(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        Student student = new Student();
        student.setName("test");
        studentService.saveStudent(student);
    }
    @Test
    public void testUpdateStudent(){
        Student s = studentService.findStudentById(1);
        s.setMajor("测试");
        studentService.updateStudent(s);
    }
    @Test
    public void testDeleteStudent(){
       studentService.deleteStudent(2);
    }
    @Test
    public void testFindStudentById(){
        Student student = studentService.findStudentById(1);
        System.out.println(student);
    }
}
