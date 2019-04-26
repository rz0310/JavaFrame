package com.renjing.test;

import com.renjing.datasource.MyDataSource;

import java.sql.Connection;
import java.sql.SQLException;
/*
SpringAop：（1）增强的代码是谁（通知）
            （2）对哪些方法进行增强（切入点）
            （3）这些增强的代码什么时候执行（切面=通知+切入点）
 */
public class DataSourceTest {
    public static void main(String[] args) throws SQLException {
        int startSize = MyDataSource.getPoolSize();
        System.out.println("使用前："+startSize);
        for (int i = 0; i < 10; i++) {
            Connection conn = MyDataSource.getConnection();
            System.out.println(conn);
            conn.close();//此时不能关闭，必须放回池里
        }

        int endSize = MyDataSource.getPoolSize();
        System.out.println("使用后："+endSize);

        for (int i = 0; i < 10; i++) {
            Connection conn = MyDataSource.getConnection();
            System.out.println(conn);
            conn.close();//此时不能关闭，必须放回池里
        }
    }
}
