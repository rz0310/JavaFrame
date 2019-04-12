package com.renjing.test;

import com.renjing.studentservicedao.StudentServiceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)//引用Spring的Junit包
@ContextConfiguration("classpath:applicationContext.xml")//上下文配置
public class MyTest {
    @Resource(name = "studentServiceDao")
    StudentServiceDao studentServiceDao;
    @Test
    public void test(){
        studentServiceDao.getStu();
    }
}
