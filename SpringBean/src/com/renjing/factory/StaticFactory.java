package com.renjing.factory;

import com.renjing.service.ICustomerService;
import com.renjing.service.imp.ICustomerServiceImp;
/*
模拟一个静态工厂
 */
public class StaticFactory {
    public static ICustomerService getCustomerService(){
        return new ICustomerServiceImp();
    }
}
