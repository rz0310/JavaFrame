package com.renjing.utils;
/*一个用于记录日志的类*/
public class Logger {
    /*
    * 记录日志的操作
    * 计划让其在业务核心方法（切入点方法）执行之前执行
    * */
    public void printLog(){
        System.out.println("Logger中的printLog开始记录日志");
    }
}
