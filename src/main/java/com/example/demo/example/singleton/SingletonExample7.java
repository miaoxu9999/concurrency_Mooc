package com.example.demo.example.singleton;

import com.example.demo.annotations.Recommend;
import com.example.demo.annotations.ThreadSafe;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @ClassName SingletonExample1
 * @Description 单例模式例子
 * 利用枚举
 * @Author miaoxu
 * @Date 2019/7/11 22:57
 * @Version 1.0
 **/
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7()
    {
    }



    public static synchronized SingletonExample7 getInstance()
    {
        return Singletion.INSTANCE.getInstance();
    }

    private enum Singletion
    {
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM 保证这个类只是被调用一次
        Singletion()
        {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
             return singleton;
        }
    }


}
