package com.mybatis.dao;

import com.mybatis.domain.Role;

import java.util.List;

public interface IRoleDao {
//    查询所有角色
    public List<Role> findAll();
}
