package com.servicedao.imp;

import com.dao.StudentGradeDao;
import com.servicedao.StudentServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceDaoImp implements StudentServiceDao {
//    引用实际操作类的接口
    @Autowired
    @Qualifier(value = "studentDaoImp")
    private StudentGradeDao studentGradeDao;
    @Override
    public void showStu() {
        System.out.println("获取成功");
    }
}
