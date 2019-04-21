package com.renjing.service.impl;

import com.renjing.bean.Student;
import com.renjing.dao.IStudentDao;
import com.renjing.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImp implements IStudentService {
    @Resource(name = "studentDao")
    private IStudentDao studentDao;

    @Override
    public List<Student> findAllStudent() {

        return studentDao.findAllStudent();
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }
}
