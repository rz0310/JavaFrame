package com.renjing.jdbctemplate;

import com.renjing.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.根据id获取bean对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
//        3.执行操作
//        保存
//        jt.update("insert into stu(id,name,age) values(?,?,?)",18,"ddd",56);
//        更新
//        jt.update("update stu set age=? where id=?",66,18);
//        删除
//        jt.update("delete from stu where id=?",5);
//        查询所有
//        RowMapper rm = null;
//        List<Student> students = jt.query("select * from stu where age > ?", new BeanPropertyRowMapper<Student>(Student.class), 20);
//        for (Student s : students) {
//            System.out.println(s);
//        }
//        查询一个
//        List<Student> students = jt.query("select * from stu where id = ?", new StudentRowMapper(), 1);
//        System.out.println(students.isEmpty()?"没有结果":students.get(0));
//        查询返回一行一列:聚合函数的使用
//        queryForObject是Spring3.x之后的新方法，在Spring2.x的时候，他的方法是多个QueryForLong、QueryForInteger
        Integer count1 = jt.queryForObject("select count(*) from stu where age > ?", Integer.class, 20);
        Long count2 = jt.queryForObject("select count(*) from stu where age > ?", Long.class, 20);
        System.out.println(count1);
        System.out.println(count2);
    }
}
class StudentRowMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int index) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
