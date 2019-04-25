package com.renjing.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
模拟一个剧组
 */
public class Client {
    public static void main(String[] args) {
        Actor actor = new Actor();
//        actor.basicAct(100);
//        actor.dangerAct(500);
        /*
        *       （2）基于子类的动态代理：
        *           要求：被代理类不能是最终类。不能被final修饰。
        *           提供者：第三方CGLib
        *           涉及的类：Enhancer
        *           创建代理对象的方法：create(Class,Callback)
        *           参数的含义：
        *               Class：被代理对象的字节码。
        *               Callback：如何代理。他和InvocationHandler的作用是一样的。
        *               他也是一个接口，我们一般使用该接口的子接口MethodInterceptor。
        *               在使用时，我么也是创建该接口的匿名内部类。
        * */
        Actor cglibactor = (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {

            /*执行被代理对象的任何方法，都会经过该方法，它和基于接口动态代理的Invoke()方法的作用相同
            *
            * 方法参数的含义：
            * MethodProxy methodProxy:当前执行方法的代理对象，一般不用。
            * */

            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
//                1.取出方法中的参数给的多少钱
                Float money = (Float) args[0];
//                2.判断当前执行的是什么方法
                if("basicAct".equals(method.getName())){
                    //基本表演
                    if (money > 10000) {
                        rtValue = method.invoke(actor,money);
                    }
                }
                if("dangerAct".equals(method.getName())){
//                    危险演出
                    if (money > 50000) {
                        //执行方法
                        rtValue = method.invoke(actor,money);
                    }
                }
                return rtValue;
            }
        });
        cglibactor.basicAct(50000);
        cglibactor.basicAct(100000);
    }
}
