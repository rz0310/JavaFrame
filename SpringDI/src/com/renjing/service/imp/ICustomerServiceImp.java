package com.renjing.service.imp;

import com.renjing.service.ICustomerService;

import java.util.Date;

//客户的业务层实现类
public class ICustomerServiceImp implements ICustomerService {

    private String driver;
    private Integer port;
    private Date today;

    public ICustomerServiceImp(String driver, Integer port, Date today) {
        this.driver = driver;
        this.port = port;
        this.today = today;
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层"+driver+","+port+","+today);
    }
}
