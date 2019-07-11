package com.example.demo.example.singleton;

import com.example.demo.annotations.NotRecommend;
import com.example.demo.annotations.ThreadSafe;

/**
 * @ClassName SingletonExample1
 * @Description 单例模式例子
 * 懒汉模式
 * 单例在第一次使用创建，线程安全
 * @Author miaoxu
 * @Date 2019/7/11 22:57
 * @Version 1.0
 **/
@ThreadSafe
public class SingletonExample4 {

    private SingletonExample4()
    {

    }

    // 单例对象 volatile + 双重检测
    private static volatile SingletonExample4 instance;

    // 1.memory = allocate()分配对象内存空间
    // 2. ctorInstance()初始化对象
    // 3. instance = memory设置instance指向刚刚分配的内存


    // JVM 和cpu优化，发生了指令重排
    public static synchronized SingletonExample4 getSingletonExample1()
    {
        if (instance == null)
        {
            synchronized (SingletonExample4.class)
            {
                if (instance == null)
                {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
