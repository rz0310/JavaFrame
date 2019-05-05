package com.renjing.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*JdbcTemplate的最基本用法*/
public class JdbcTemplateDemo {
    public static void main(String[] args) {
//        定义数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/up1");
        ds.setUsername("root");
        ds.setPassword("root");
//        1.获取对象
//        JdbcTemplate jt = new JdbcTemplate(ds);
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);//设置数据源
//        2.执行操作
        jt.execute("insert into stu(id,name,age) values(16,'jiayou',22)");
    }
}
