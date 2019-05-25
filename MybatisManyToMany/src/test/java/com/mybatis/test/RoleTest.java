package com.mybatis.test;

import com.mybatis.dao.IRoleDao;
import com.mybatis.dao.IUserDao;
import com.mybatis.domain.Role;
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

public class RoleTest {
    InputStream inputStream = null;
    SqlSession sqlSession = null;
    IRoleDao roleDao;
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
        roleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> roleList = roleDao.findAll();
       for(Role u : roleList){
           System.out.println(u);
           System.out.println(u.getUsers());
       }
//        System.out.println(roleList);
    }
}
