package com.renjing.mybatis.daoimp;

import com.renjing.mybatis.mapper.OrdersUserMapper;
import com.renjing.mybatis.po.OrdersUserCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HigherMapperTest {
    SqlSession sqlSession = null;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void findOrderUserListTest(){
        OrdersUserMapper ordersUserMapper = sqlSession.getMapper(OrdersUserMapper.class);
        List<OrdersUserCustomer> orderUserList = ordersUserMapper.findOrderUserList();
        System.out.println(orderUserList);
    }
}
