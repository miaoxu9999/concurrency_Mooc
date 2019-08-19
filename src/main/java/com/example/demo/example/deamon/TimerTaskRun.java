package com.example.demo.example.deamon;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Callable;

/**
 * @ClassName TimerTaskRun
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/8/19 20:37
 * @Version 1.0
 **/
public class TimerTaskRun {
    public static void main(String[] args) {
        System.out.println("系统当前时间为" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date date = calendar.getTime();
        MyTask myTask = new MyTask();
        Timer timer = new Timer(true);
        timer.schedule(myTask, date);
    }
}
