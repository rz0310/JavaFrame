package com.renjing.service.imp;

import com.renjing.service.ICustomerService;

public class CustomerServiceImp implements ICustomerService {

    @Override
    public void saveCustomer() {
        System.out.println("业务层保存了客户");
    }
}
