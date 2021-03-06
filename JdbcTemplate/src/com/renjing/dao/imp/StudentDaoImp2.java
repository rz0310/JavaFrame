package com.renjing.dao.imp;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImp2 extends JdbcDaoSupport implements IStudentDao {

    @Override
    public Student fingStudentById(Integer id) {
        List<Student> students = getJdbcTemplate().query("select * from stu where id = ?", new BeanPropertyRowMapper<Student>(Student.class), id);
        return students.isEmpty()?null: students.get(0);
    }

    @Override
    public Student findStudentByName(String name) {
        List<Student> students = getJdbcTemplate().query("select * from stu where name = ?", new BeanPropertyRowMapper<Student>(Student.class), name);
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
        getJdbcTemplate().update("update stu set name=?,age=? where id=?", student.getName(), student.getAge(), student.getId());
    }
}
