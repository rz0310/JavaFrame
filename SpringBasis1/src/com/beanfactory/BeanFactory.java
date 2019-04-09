package com.beanfactory;

import com.bean.Dog;

public class BeanFactory {
    public static Dog getBean(){
        return new Dog();
    }
    public Dog getBean2(){
        return new Dog();
    }
}
