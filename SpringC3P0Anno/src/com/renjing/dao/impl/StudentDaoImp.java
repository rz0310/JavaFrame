package com.renjing.dao.impl;

import com.renjing.bean.Student;
import com.renjing.dao.IStudentDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
/*
客户的持久层实现类
 */
@Repository("studentDao")
public class StudentDaoImp implements IStudentDao {
    @Resource(name = "runner")
    private QueryRunner runner;

    public StudentDaoImp() {
    }

    @Override
    public List<Student> findAllStudent() {
        try {
            return runner.query("select * from stu",new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveStudent(Student student) {
        try {
            runner.update("insert into stu(name,age,class,major,image) values(?,?,?,?,?)",student.getName(),student.getAge(),student.getClazz(),student.getMajor(),student.getImage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            runner.update("update stu set id=?,name=?,age=?,class=?,major=?,image=? where id=?",student.getId(),student.getName(),student.getAge(),student.getClazz(),student.getMajor(),student.getImage(),student.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            runner.update("delete from stu where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findStudentById(int id) {
        try {
            return runner.query("select * from stu where id=?",new BeanHandler<Student>(Student.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
