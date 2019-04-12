package com.renjing.studentdaoimp;

import com.renjing.bean.Student;
import com.renjing.studentdao.StudentDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("studentDao")
public class StudentDaoImp implements StudentDao {

    @Resource(name = "student")
    Student student;
    @Override
    public List<Student> getStu() {
        System.out.println("我是Student的实际操作类");
        student.toString();
        return null;
    }
}
