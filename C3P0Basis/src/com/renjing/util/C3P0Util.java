package com.renjing.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/*
c3p0数据源工具类
 */
public class C3P0Util {
//    定义一个数据源对象
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    /*
    当我们使用配置文件时，并且配置文件按照文档要求，放到顶层构件路径中，就可以不用设置参数的值
     */
    static {
        try {
            ds = new ComboPooledDataSource();
//        ds = new ComboPooledDataSource("oracle");//通过构造函数来指定读取配置文件中的哪段配置
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/up1?characterEncoding=utf-8");
            ds.setUser("root");
            ds.setPassword("root");
        } catch (PropertyVetoException e) {
            throw new ExceptionInInitializerError("初始化连接失败");
        }
    }
//    获取数据源
    public static DataSource getDataSource(){
        return ds;
    }
//    获取一个连接
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
