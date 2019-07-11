package com.example.demo.example.singleton;

import com.example.demo.annotations.NotRecommend;
import com.example.demo.annotations.NotThreadSafe;
import com.example.demo.annotations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 单例模式例子
 * 懒汉模式
 * 单例在第一次使用创建，线程安全，不推荐使用
 * @Author miaoxu
 * @Date 2019/7/11 22:57
 * @Version 1.0
 **/
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3()
    {

    }

    private static SingletonExample3 instance;

    public static synchronized SingletonExample3 getSingletonExample1()
    {
        if (instance == null)
        {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
