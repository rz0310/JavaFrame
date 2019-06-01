package com.renjing.mybatis.daoimp;

import static org.junit.Assert.assertTrue;

import com.renjing.mybatis.dao.UserDao;
import com.renjing.mybatis.dao.imp.UserDaoImp;
import com.renjing.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class DaoImptest {
    /**
     * Rigorous Test :-)
     */
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void findUserByIdTest() throws IOException {
        UserDao userDao = new UserDaoImp(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void shouldAnswerWithTrue()
    {
       /* UserDao userDao = new UserDaoImp();
        try {
            1.按照id查找
            userDao.findUserById(1);
            2.按照name查找
            userDao.findUserByName("ing");
            3.插入
            User user = new User();
            user.setUsername("qqq");
            user.setPassword("111");
            userDao.insertUser(user);
            System.out.println(user.getId());
            4.删除
            userDao.deleteUser(14);
            5.更新
            User user = new User();
            必须设置id
            user.setId(12);
            user.setUsername("666");
            user.setPassword("666");
            userDao.updateUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
//        Assert.assertNotNull(user);
    }
}
