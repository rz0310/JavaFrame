package com.renjing.dao.imp;

import com.renjing.dao.ICustomerDao;
import org.springframework.stereotype.Repository;

//模拟客户的持久层实现类
@Repository("customerDao1")
public class ICustomerDaoImp implements ICustomerDao {
    @Override
    public void saveCustomer() {
        System.out.println("持久层保存了客户111");
    }
}
