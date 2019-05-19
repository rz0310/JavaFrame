package com.renjing.dao;

import com.renjing.domain.Student;

/*账户的持久层接口*/
public interface IStudentDao {
    //    根据id查询信息
    Student fingStudentById(Integer id);
//    根据name查询学生信息 要求：账户名称必须唯一，如果不唯一，应该抛异常
    Student findStudentByName(String name);
//    更新账户信息
    void updateStudent(Student student);
}
