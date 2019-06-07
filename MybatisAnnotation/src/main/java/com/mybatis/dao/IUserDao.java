package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 * */
public interface IUserDao {
//    查询所有用户
    @Select("select * from user")
    public List<User> findAll();
//    插入用户
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    public void insertUser(User user);
//    更新用户
    @Update("update user set username=#{username},address=#{address}")
    public void updateUser(User user);
//    删除用户
    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);
//    根据id查询用户
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);
//    根据用户名称模糊查询
//    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    public List<User> findByName(String name);
//    查询总用户数量
    @Select("select count(*) from user")
    public Integer findTotal();
}
