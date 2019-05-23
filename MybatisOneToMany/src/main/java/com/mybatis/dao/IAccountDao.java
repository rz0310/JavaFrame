package com.mybatis.dao;

import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    //    查询所有账户
    public List<Account> findAll();
//    查询所有账户，包含用户名和地址
    public List<AccountUser> findAllAccount();
}
