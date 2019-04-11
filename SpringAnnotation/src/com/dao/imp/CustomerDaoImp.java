package com.dao.imp;

import com.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository(value = "customerDao")
public class CustomerDaoImp implements CustomerDao {
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${driverClass}")
    private String driverClass;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;

    @Override
    public void save() {
        System.out.println("CustomerDaoImp的save方法");
    }

    @Override
    public String toString() {
        return "CustomerDaoImp{" +
                "jdbcUrl='" + jdbcUrl + '\'' +
                ", driverClass='" + driverClass + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
