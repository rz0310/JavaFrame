package com.renjing.test;

import com.renjing.domain.Student;
import com.renjing.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//加载配置文件
        IStudentService studentService = (IStudentService) ac.getBean("studentService");//获取StudentService的bean对象
        Student student = studentService.findStudentById(1);//按照id查找
        System.out.println(student);
        studentService.transfer("aaa","bbb",100);//转账操作
    }
}
