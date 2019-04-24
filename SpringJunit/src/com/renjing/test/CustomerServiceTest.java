package com.renjing.test;

import com.renjing.annotation.MyTest;
import com.renjing.service.ICustomerService;
import com.renjing.service.imp.CustomerServiceImp;

public class CustomerServiceTest {
    @MyTest
    public void CustomerServiceTest(){
        System.out.println("测试方法执行");
        ICustomerService customerService = new CustomerServiceImp();
        customerService.saveCustomer();
    }
}
