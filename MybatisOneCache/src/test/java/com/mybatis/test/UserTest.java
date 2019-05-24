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
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        inputStream.close();
        sqlSession.close();
    }
    @Test
    public void oneCacheTest(){
        User user = userDao.findById(1);
        System.out.println(user);

        sqlSession.close();//关闭sqlSession
//        sqlSession.clearCache();//也可用此方法清除sqlSession的一级缓存
        sqlSession = sqlSessionFactory.openSession();//再次开启sqlSession
        userDao = this.sqlSession.getMapper(IUserDao.class);

        User user2 = userDao.findById(1);
        System.out.println(user2);
        System.out.println(user == user2);

    }
    @Test
    public void synOneCacheTest(){
//        1.根据id查询用户
        User user = userDao.findById(7);
        System.out.println(user);

//        2.更新用户信息
        user.setUsername("小仙女");
        user.setAddress("开发区");
        userDao.updateUser(user);
        sqlSession.commit();//提交sqlSession

//        3.再次根据id查询
        User user2 = userDao.findById(7);
        System.out.println(user2);
        System.out.println(user == user2);

    }
}
