package com.studentdao.imp;

import com.studentdao.StudentDao;

public class StudentDaoImp implements StudentDao {

    @Override
    public void study(String name) {
        System.out.println(name);
    }
}
