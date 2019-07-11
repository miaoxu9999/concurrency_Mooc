package com.example.demo.example.singleton;

import com.example.demo.annotations.NotThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 单例模式例子
 * 懒汉模式
 * 单例在第一次使用创建
 * @Author miaoxu
 * @Date 2019/7/11 22:57
 * @Version 1.0
 **/
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1()
    {

    }

    private static SingletonExample1 instance;

    public static SingletonExample1 getSingletonExample1()
    {
        if (instance == null)
        {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
