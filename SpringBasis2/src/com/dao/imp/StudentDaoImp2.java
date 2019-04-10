package com.dao.imp;

import com.bean.Student;
import com.dao.StudentGradeDao;

public class StudentDaoImp2 implements StudentGradeDao {
    @Override
    public void getGrade(Student student) {
        System.out.println("实现类2");
    }

    @Override
    public void getGrade() {

    }
}
