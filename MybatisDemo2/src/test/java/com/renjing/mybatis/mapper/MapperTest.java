package com.renjing.mybatis.mapper;

import com.renjing.mybatis.po.User;
import com.renjing.mybatis.po.UserCustomer;
import com.renjing.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void findUserByIdTest(){
//        使用会话工厂创建一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        由当前会话根据反射获取UserMapper的接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        使用UserMapper进行数据库操作
        User user = userMapper.findUserById(1);
        sqlSession.commit();
        System.out.println(user);
    }
    @Test
    public void findUserByIdResultMapTest(){
//        使用会话工厂创建一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        由当前会话根据反射获取UserMapper的接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        使用UserMapper进行数据库操作
        User user = userMapper.findUserByIdResultMap(1);
        sqlSession.commit();
        System.out.println(user);
    }
    @Test
    public void findUserByNameTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByName("ing");
        sqlSession.commit();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void findUserListTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setUsername("ing");
        userCustomer.setPassword("2");

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(10);
        idList.add(11);
        userQueryVo.setUserCustomer(userCustomer);
        userQueryVo.setIdList(idList);

        List<UserCustomer> userList = userMapper.findUserList(userQueryVo);
        System.out.println(userList);
    }
    @Test
    public void findUserCountTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setUsername("ing");
//        userCustomer.setPassword("2");

        userQueryVo.setUserCustomer(userCustomer);

        Integer count = userMapper.findUserCount(userQueryVo);
        System.out.println(count);
    }
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(11);
        user.setUsername("xxx");
        user.setPassword("xxx");
        boolean b = userMapper.insertUser(user);
        sqlSession.commit();
        System.out.println(b);
        sqlSession.close();
    }
    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean b = userMapper.deleteUser(1);
        sqlSession.commit();
        System.out.println(b);
        sqlSession.close();
    }
}
