package com.renjing.service;

import com.renjing.bean.Student;

import java.util.List;

//客户的业务层接口
public interface IStudentService {
//    查询所有客户
    List<Student> findAllStudent();
//    保存客户
    void saveStudent(Student student);
//    更新客户
    void updateStudent(Student student);
//    根据Id删除客户
    void deleteStudent(int id);
//    根据Id查询客户
    Student findStudentById(int id);
}
