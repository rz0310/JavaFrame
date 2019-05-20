package com.renjing.dao.imp;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
操作层实现类
*/
@Repository("studentDao")
public class StudentDaoImp implements IStudentDao {
	//自动装配
    @Autowired
    private JdbcTemplate jdbcTemplate;
	//按照id查找
    @Override
    public Student fingStudentById(Integer id) {
        List<Student> students = jdbcTemplate.query("select * from stu where id = ?", new BeanPropertyRowMapper<Student>(Student.class), id);
        return students.isEmpty()?null: students.get(0);
    }

    @Override
    public Student findStudentByName(String name) {
        List<Student> students = jdbcTemplate.query("select * from stu where name = ?", new BeanPropertyRowMapper<Student>(Student.class), name);
        if (students.isEmpty()) {
            return null;
        }
        if (students.size() > 1) {
            throw new RuntimeException("结果集不唯一，请检查数据");
        }
        return students.get(0);
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update("update stu set money=? where id=?", student.getMoney(), student.getId());
    }
}
