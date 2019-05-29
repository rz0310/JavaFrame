package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    //    @Select("select * from user")
//    查询所有
    public List<User> findAll();

    //    插入用户
    public void insertUser(User user);

    //    更新用户
    public void updateUser(User user);
//    删除用户
    public void deleteUser(Integer id);
//    按照id查询
    public User findUserById(Integer id);
//    查询用户总记录数
    public Integer findTotal();
//    按照名称模糊查询
    public List<User> findUserByName(String name);
}
