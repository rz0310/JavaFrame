package com.mybatis.test;

import com.mybatis.domain.Account;
import com.mybatis.dao.IAccountDao;
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

public class AccountTest {
    SqlSessionFactory sqlSessionFactory = null;
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    IAccountDao accountDao;
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
        accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accountList = accountDao.findAll();
       for(Account a : accountList){
           System.out.println(a);
           System.out.println(a.getUser());
       }
    }
}
