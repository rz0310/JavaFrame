package com.renjing.factory;

import com.renjing.service.ICustomerService;
import com.renjing.service.imp.ICustomerServiceImp;
/*
模拟一个实例工厂
 */
public class InstanceFactory {
    public ICustomerService getCustomerService(){
        return new ICustomerServiceImp();
    }
}
