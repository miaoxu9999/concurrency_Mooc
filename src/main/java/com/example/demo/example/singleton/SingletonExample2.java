package com.example.demo.example.singleton;

import com.example.demo.annotations.ThreadSafe;

/**
 * @ClassName SingletonExample2
 * @Description 饿汉模式
 * 单例实例在类加载使用时创建,线程安全
 * @Author miaoxu
 * @Date 2019/7/11 23:03
 * @Version 1.0
 **/
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2()
    {

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance()
    {
        return instance;
    }
}
