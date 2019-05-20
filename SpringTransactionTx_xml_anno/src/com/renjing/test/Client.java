package com.renjing.test;

import com.renjing.domain.Student;
import com.renjing.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IStudentService studentService = (IStudentService) ac.getBean("studentService");
        Student student = studentService.findStudentById(1);
        System.out.println(student);
        studentService.transfer("aaa","bbb",100);
    }
}
