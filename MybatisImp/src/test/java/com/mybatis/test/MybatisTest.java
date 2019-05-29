package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.dao.impl.UserDaoImp;
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

public class MybatisTest {
    InputStream inputStream = null;
    IUserDao userDao = null;
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDao = new UserDaoImp(sqlSessionFactory);
    }
    @Test
    public void findAllTest(){
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void insertUserTest(){
        User user = new User();
        user.setUsername("小仙女");
        user.setAddress("天上");
        user.setSex("女");
        System.out.println("插入前："+user);
//        user.setBirthday(new Date());
        userDao.insertUser(user);
        System.out.println("插入后："+user);
    }
    @Test
    public void updateUserTest(){
        User user = new User();
        user.setId(4);
        user.setUsername("小仙女");
        user.setAddress("天上");
        user.setSex("女");
        userDao.updateUser(user);
    }
    @Test
    public void deleteUserTest(){
        userDao.deleteUser(4);
    }
    @Test
    public void findUserByIdTest(){
        User user = userDao.findUserById(3);
        System.out.println(user);
    }
    @Test
    public void findUserByNameTest(){
        List<User> users = userDao.findUserByName("%张%");//推荐使用此种方式，采用了占位符预编译statement
        System.out.println(users);
    }
    @Test
    public void findTotalTest(){
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
    @After
    public void destory() throws IOException {
        inputStream.close();
    }
}
