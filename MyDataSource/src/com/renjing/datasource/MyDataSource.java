package com.renjing.datasource;

import com.renjing.utils.DBUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*自定义连接池*/
public class MyDataSource {
//    定义一个池，用于存放连接
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<>());

//    使用静态代码块给池中加入连接
    static {
        for (int i = 0; i < 10; i++) {
            Connection conn = DBUtil.getConn();
            pool.add(conn);
        }
    }

//    获取一个连接
    public static Connection getConnection(){
        Connection conn = pool.remove(0);
        Connection connProxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
//                判断当前方法是不是close方法
                if ("close".equals(method.getName())) {
//                    不能直接关闭
                    pool.add(conn);//还回池中
                }else{
                    rtValue = method.invoke(conn,args);
                }
                return rtValue;
            }
        });
        return connProxy;
    }

//    获取池中的连接数
    public static int getPoolSize(){
        return pool.size();
    }
}
