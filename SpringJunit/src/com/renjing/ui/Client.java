package com.renjing.ui;

import com.renjing.annotation.MyTest;
import com.renjing.test.CustomerServiceTest;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws Exception{
//        1.获取测试类的字节码
        Class<CustomerServiceTest> clazz = CustomerServiceTest.class;
//        2.获取该类的字节码中的所有方法
        Method[] methods = clazz.getMethods();
//        3.遍历方法的数组
        for(Method method:methods){
//            4.判断method上是否有注解
            boolean b = method.isAnnotationPresent(MyTest.class);
            System.out.println(method.getName()+"="+b);
            if(b){
                method.invoke(clazz.newInstance(),null);
            }
        }
    }
}
