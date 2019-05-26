package com.mybatis.dao;

import com.mybatis.domain.Account;

import java.util.List;

public interface IAccountDao {
    //    查询所有账户
    public List<Account> findAll();
    public List<Account> findByUid(Integer id);
}
