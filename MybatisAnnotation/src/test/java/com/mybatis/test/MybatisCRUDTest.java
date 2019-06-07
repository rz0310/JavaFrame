package com.mybatis.test;

import com.mybatis.dao.IUserDao;
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
import java.util.Date;
import java.util.List;

public class MybatisCRUDTest {
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    IUserDao userDao;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void insertUserTest(){
        User user = new User();
        user.setUsername("insert");
        user.setAddress("jiay");
        user.setSex("女");
        userDao.insertUser(user);
    }
    @Test
    public void updateUserTest(){
        User user = new User();
        user.setId(9);
        user.setUsername("update");
        user.setAddress("hh");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void deleteUserTest(){
        userDao.deleteUser(9);
    }
    @Test
    public void findByIdTest(){
        User user = userDao.findById(3);
        System.out.println(user);
    }
    @Test
    public void findByNameTest(){
//        List<User> userList = userDao.findByName("%cong%");
        List<User> userList = userDao.findByName("cong");
        System.out.println(userList);
    }
    @Test
    public void findTotalTest(){
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
}
