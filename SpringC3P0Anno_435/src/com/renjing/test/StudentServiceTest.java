package com.renjing.test;

import com.renjing.bean.Student;
import com.renjing.service.IStudentService;
import config.SpringConfigration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

/*
测试客户的业务层
 */
public class StudentServiceTest {
    @Test
    public void testFindAllStudent(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
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
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        Student s = studentService.findStudentById(1);
        s.setMajor("测试");
        studentService.updateStudent(s);
    }
    @Test
    public void testDeleteStudent(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
    }
    @Test
    public void testFindStudentById(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
    }
}
