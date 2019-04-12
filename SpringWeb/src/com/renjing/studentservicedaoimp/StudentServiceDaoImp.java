package com.renjing.studentservicedaoimp;

import com.renjing.bean.Student;
import com.renjing.studentdao.StudentDao;
import com.renjing.studentservicedao.StudentServiceDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("studentServiceDao")
public class StudentServiceDaoImp implements StudentServiceDao {

    @Resource(name = "studentDao")
    StudentDao studentDao;
    @Override
    public List<Student> getStu() {
        studentDao.getStu();
        return null;
    }
}
