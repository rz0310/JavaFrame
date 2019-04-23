package com.renjing.test;

import com.renjing.bean.Student;
import com.renjing.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/*
测试客户的业务层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class StudentServiceTest {
    @Resource(name = "IStudentService")
    private IStudentService studentService = null;
    @Test
    public void testFindAllStudent() {
        List<Student> list = studentService.findAllStudent();
        for (Student s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setName("任静");
        studentService.saveStudent(student);
    }

    @Test
    public void testUpdateStudent() {
        Student s = studentService.findStudentById(1);
        s.setMajor("测试");
        studentService.updateStudent(s);
    }

    @Test
    public void testDeleteStudent() {
        studentService.deleteStudent(3);
    }

    @Test
    public void testFindStudentById() {
        Student student = studentService.findStudentById(4);
        System.out.println(student);
    }
}
