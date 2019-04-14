package com.renjing.service.imp;

import com.renjing.service.ICustomerService;

//客户的业务层实现类
public class ICustomerServiceImp implements ICustomerService {

    public ICustomerServiceImp() {
        System.out.println("bean对象被创建了");
    }

    public void init(){
        System.out.println("对象创建");
    }
    public void destory(){
        System.out.println("对象销毁");
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层");
    }
}
