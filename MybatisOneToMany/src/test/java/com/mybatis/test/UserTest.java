package com.mybatis.test;

import com.mybatis.dao.IAccountDao;
import com.mybatis.dao.IUserDao;
import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    SqlSessionFactory sqlSessionFactory = null;
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    IUserDao userDao;
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }
    @After
    public void destory() throws IOException {
//        sqlSession.commit();
        inputStream.close();
        sqlSession.close();
    }
    @Test
    public void findAllTest(){
        userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
       for(User u : userList){
           System.out.println(u);
           System.out.println(u.getAccounts());
       }
//        System.out.println(userList);
    }
}
