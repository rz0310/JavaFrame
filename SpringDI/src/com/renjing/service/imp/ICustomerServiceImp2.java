package com.renjing.service.imp;

import com.renjing.service.ICustomerService2;

import java.util.Date;

//客户的业务层实现类
public class ICustomerServiceImp2 implements ICustomerService2 {

    private String driver;
    private Integer port;
    private Date today;

    public ICustomerServiceImp2() {
    }

    public ICustomerServiceImp2(String driver, Integer port, Date today) {
        this.driver = driver;
        this.port = port;
        this.today = today;
    }


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层"+driver+","+port+","+today);
    }
}
