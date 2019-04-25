package com.renjing.cglib;

import com.renjing.proxy.IActor;

/*
模拟一个演员
* */
public class Actor implements IActor {
    public void basicAct(float money){
        System.out.println("CGLib拿到前，开始基本的表演："+money);
    }
    public void dangerAct(float money){
        System.out.println("CGLib拿到钱，开始危险的表演:"+money);
    }
}
