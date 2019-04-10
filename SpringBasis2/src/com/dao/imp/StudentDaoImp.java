package com.dao.imp;

import com.bean.Student;
import com.dao.StudentGradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDaoImp implements StudentGradeDao {
    @Autowired
    private Student student;

    public StudentDaoImp(Student student) {
        this.student = student;
    }

    @Override
    public void getGrade(Student student) {
        System.out.println("实现类1");
        System.out.println(student.getGrade());
    }

    @Override
    public void getGrade() {
        System.out.println(student.getGrade());
    }

    public StudentDaoImp() {
    }
}
