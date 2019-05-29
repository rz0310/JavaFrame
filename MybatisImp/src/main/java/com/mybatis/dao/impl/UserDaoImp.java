package com.mybatis.dao.impl;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImp implements IUserDao {
    SqlSessionFactory sqlSessionFactory = null;
    public UserDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.mybatis.dao.IUserDao.findAll");
        sqlSession.close();
        return userList;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.mybatis.dao.IUserDao.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("com.mybatis.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.mybatis.dao.IUserDao.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.mybatis.dao.IUserDao.findUserById", id);
        return user;
    }

    @Override
    public Integer findTotal() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer count = sqlSession.selectOne("com.mybatis.dao.IUserDao.findTotal");
        return count;
    }

    @Override
    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.mybatis.dao.IUserDao.findUserByName", name);
        return userList;
    }
}
