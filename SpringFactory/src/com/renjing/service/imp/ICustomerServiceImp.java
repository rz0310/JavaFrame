package com.renjing.service.imp;

import com.renjing.dao.ICustomerDao;
import com.renjing.dao.imp.ICustomerDaoImp;
import com.renjing.factory.BeanFactory;
import com.renjing.service.ICustomerService;

//客户的业务层实现类
public class ICustomerServiceImp implements ICustomerService {
    private ICustomerDao customerDao = null;
//    private ICustomerDao customerDao = new ICustomerDaoImp();
//    private ICustomerDao customerDao = (ICustomerDao) BeanFactory.getBean("CUSTOMERDAO");

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层");
        customerDao.saveCustomer();
    }
}
