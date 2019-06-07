package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
//    测试给予注解的mybatis的使用
    public static void main(String[] args) throws IOException {
//        1.获取字节输入流
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据字节数入流构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.根据SqlSessionFactory生产一个SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.使用SqlSession获取Dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//        5.执行Dao的方法
        List<User> userList = userDao.findAll();
        for (User user:userList){
            System.out.println(user);
        }
//        6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
