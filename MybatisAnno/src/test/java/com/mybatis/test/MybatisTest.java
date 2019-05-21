package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import com.mybatis.domain.UserQueryVo;
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

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory = null;
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }
    @Test
    public void findAllTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void insertUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("小仙女111");
        user.setAddress("天上");
        user.setSex("女");
        System.out.println("插入前："+user);
//        user.setBirthday(new Date());
        boolean insert = userDao.insertUser(user);
        System.out.println(insert);
        System.out.println("插入后："+user);
    }
    @Test
    public void updateUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(4);
        user.setUsername("小仙女nvnv");
        user.setAddress("天上");
        user.setSex("女");
        userDao.updateUser(user);
    }
    @Test
    public void deleteUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.deleteUser(9);
    }
    @Test
    public void findUserByIdTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.findUserById(3);
        System.out.println(user);
    }
    @Test
    public void findUserByNameTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findUserByName("%张%");//推荐使用此种方式，采用了占位符预编译statement
//        List<User> users = userDao.findUserByName("张");//此处采用的是字符串拼接
        System.out.println(users);
    }
    @Test
    public void findTotalTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
    @Test
    public void findUserByNameQueryVoTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("%张%");
        userQueryVo.setUser(user);
        List<User> users = userDao.findUserByNameQueryVo(userQueryVo);
        System.out.println(users);
    }
    @After
    public void destory() throws IOException {
//        sqlSession.commit();
        inputStream.close();
        sqlSession.close();
    }
}
