package com.renjing.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/*
JdbcTemplate的入门
*/
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
//        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.根据id获取bean对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
//        3.执行操作
        jt.execute("insert into stu(id,name,age) values(17,'hhhh',220)");
    }
}
