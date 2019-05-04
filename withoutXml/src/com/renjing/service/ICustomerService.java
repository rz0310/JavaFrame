package com.renjing.service;

/*
模拟一个客户的业务层接口
 */
public interface ICustomerService {
//    保存客户
    void saveCustomer();
//    更新客户
    void updateCustomer(int i);
//    删除客户
    int deleteCustomer();
}
