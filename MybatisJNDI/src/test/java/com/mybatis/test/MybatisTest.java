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

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
        System.out.println(userList);
        inputStream.close();
        sqlSession.close();
    }
}
