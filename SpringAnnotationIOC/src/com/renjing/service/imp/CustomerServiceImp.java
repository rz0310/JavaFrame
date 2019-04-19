package com.renjing.service.imp;

import com.renjing.dao.ICustomerDao;
import com.renjing.dao.imp.ICustomerDaoImp;
import com.renjing.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*客户的业务层实现类
    1.用于创建bean对象
        @Component：
            作用：就相当于配置了一个bean标签
            他能出现的位置：类上面
            属性：value。涵义是指bean的Id。当不写时，他有默认值，默认值是：当前类的短名首字母小写。
            由此注解衍生的三个注解：
            @Controller：一般用于表现的注解。
            @Service：一般用于业务层。
            @Repository：一般用于持久层
            它们和@Component的作用及属性都是一模一样。
    2.用于注入数据
        @Autowired
                作用：自动按照类型注入。只要有唯一的类型匹配就能注入成功。
                当我们使用注解注入时，set方法就不是必须的了。
                如果注入的bean在容器中类型不唯一时，它会把变量名称作为bean的id
                ，在容器中查找，找到后也能注入成功。
                如果没有找到一致的bean的id，则报错。
        @Qualifier
                作用：在自动按照类型注入的基础之上，再按照bean的id注入.
                它在给类成员注入数据时，不能独立使用，但是在给方法的形参注入数据时，可以独立使用。
                属性：
                    value：用于指定bean的id。
        @Resource
                作用：直接按照bean的id注入。
                属性：
                    name：用于指定bean的id。
                    以上三个注解都是用于注入其他bean类型的。用于注入基本类型和String类型需要使用Value。
        @Value：
                作用：用于注入基本类型和String类型数据。
                它可以借助spring的el表达式读取properties文件中的配置。
                属性：
                    value：用于指定要注入的数据。
    3.用于改变范围的
        @Scope
            作用：用于改变bean的作用范围。
            属性：
                value：用于改变bean的作用范围。
                取值和scope属性的取值是一样的。singleton prototype session globalsession
    4.和生命周期相关的
    5.Spring的新注解
*/
@Service("customerService")
@Scope("prototype")
public class CustomerServiceImp implements ICustomerService {
    @Value("任静")
    private String name;

    //    @Autowired//自动装配
//    @Qualifier("customerDao2")
    @Resource(name = "customerDao2")
    private ICustomerDao customerDao = null;

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层:" + name);
        customerDao.saveCustomer();
    }
}
