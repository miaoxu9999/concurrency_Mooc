package com.example.demo.example.deamon;

import java.util.Date;
import java.util.TimerTask;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/8/19 20:39
 * @Version 1.0
 **/
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为："+new Date());
    }
}
