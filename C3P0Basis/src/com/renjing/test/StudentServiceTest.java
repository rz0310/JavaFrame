package com.renjing.test;

import com.renjing.bean.Student;
import com.renjing.service.IStudentService;
import com.renjing.service.impl.StudentServiceImp;
import org.junit.Test;

import java.util.List;

/*
测试客户的业务层
 */
public class StudentServiceTest {
    @Test
    public void testFindAllStudent(){
        IStudentService studentService = new StudentServiceImp();
        List<Student> list = studentService.findAllStudent();
        for (Student s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void testSaveStudent(){
        IStudentService studentService = new StudentServiceImp();
        Student student = new Student();
        student.setName("任静");
        studentService.saveStudent(student);
    }
}
