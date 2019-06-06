package com.mybatis.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
//        数据库连接
        Connection connection = null;
//        预编译的Statement，使用预编译的Statement提高数据库性能
        PreparedStatement preparedStatement = null;
//        结果集
        ResultSet resultSet = null;
        try {
//            加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
//            通过数据库驱动管理类来获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1","root","root");
            String sql = "select * from user where username = ?";
//            获取预处理的statement
            preparedStatement  = connection.prepareStatement(sql);
//            设置参数
            preparedStatement.setString(1, "renjing");
//            获取结果集
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" "+resultSet.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
