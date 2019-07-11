package com.example.demo.example.singleton;

import com.example.demo.annotations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 单例模式例子
 * 饿汉模式
 * 单例在类加载时创建
 * @Author miaoxu
 * @Date 2019/7/11 22:57
 * @Version 1.0
 **/
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6()
    {
    }

    private static  SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static synchronized SingletonExample6 getInstance()
    {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
