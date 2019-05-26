package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

public interface IUserDao {
//    查询所有
    public List<User> findAll();
//    根据id查询
    public User findById(Integer id);
}
