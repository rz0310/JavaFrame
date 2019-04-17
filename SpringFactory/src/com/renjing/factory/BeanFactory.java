package com.renjing.factory;

import com.renjing.dao.ICustomerDao;
import com.renjing.service.ICustomerService;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//一个工厂类
public class BeanFactory {
//    根据Bean的名称创建类对象
//    1.定义一个properties对象
    private static Properties properties = new Properties();
//    2.只用静态代码块给对象赋值
    static {
        try {
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");//文件要放在类路径下
//            InputStream in = new FileInputStream("src/bean.properties");//绝对不能用，web工厂一旦发布，就没有src了
            properties.load(in);
        } catch (IOException e) {
//            throw new ExceptionInInitializerError("读取配置文件失败"+e);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(properties.get("CUSTOMERDAO"));
    }

//    1.他只能用于读取properties文件，别的文件读不了
//    2.他只能用于读取，不能用于写入
//    3.他只能读取类路径下的，不再类路径下读取不了
//    注意：方法参数的写法是按照包名.类名的方式，不可以写扩展名
    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

//    1.定义一个容器，用于存放我们要使用的对象
    private static Map<String,Object> beans = new HashMap<>();

//    使用静态代码，初始化Map
    static{
        try {
//        1.读取配置文件中所有的配置：key的部分
            Enumeration<String> keys = bundle.getKeys();
//        2.遍历keys
            while(keys.hasMoreElements()){
//        3.取出一个key
                String key = keys.nextElement();
//        4.根据key获取beanPath
                String beanPath = bundle.getString(key);
//        5.根据beanPath反射创建类对象
                Object value = Class.forName(beanPath).newInstance();
//        6.把key和value存入map中
                beans.put(key,value);
             }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("容器创建失败，程序停止运行");
        }
}

    public static Object getBean(String beanName) {
//        1.方法一
//        try {
////            1.读取配置文件，根据beanName获取全限定类名
//            String beanPath = bundle.getString(beanName);
//            return Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        2.方法二：根据bean的唯一标识获取对象
        return beans.get(beanName);
    }
    public static ICustomerDao getCustomerDao() {
        try {
            return (ICustomerDao)Class.forName("").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
