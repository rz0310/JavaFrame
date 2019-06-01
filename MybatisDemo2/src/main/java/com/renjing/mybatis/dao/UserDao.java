package com.renjing.mybatis.dao;

import com.renjing.mybatis.po.User;

import java.io.IOException;

public interface UserDao {
//    public User findUserById(int id) throws IOException;
//    public void findUserById(Integer id) throws IOException;
//    public void findUserByName(String name) throws IOException;
//    public void updateUser(User user) throws IOException;


    public User findUserById(Integer id) throws IOException;
    public void insertUser(User user) throws IOException;
    public void deleteUser(Integer id) throws IOException;
}
