package com.renjing.service.impl;

import com.renjing.service.ICustomerService;
import com.renjing.utils.Logger;

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public void saveCustomer() {
        System.out.println("保存了客户");
    }

    @Override
    public void updateCustomer(int i) {
        System.out.println("更新了客户");
    }

    @Override
    public int deleteCustomer() {
        System.out.println("删除了客户");
        return 0;
    }
}
