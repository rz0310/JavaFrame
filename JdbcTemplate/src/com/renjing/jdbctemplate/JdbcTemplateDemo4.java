package com.renjing.jdbctemplate;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.根据id获取bean对象
        IStudentDao studentDao = (IStudentDao) ac.getBean("studentDao2");
//        3.执行操作
        Student student = studentDao.fingStudentById(1);
        System.out.println(student);
        student.setName("张聪");
        studentDao.updateStudent(student);
        System.out.println(student);
    }
}

