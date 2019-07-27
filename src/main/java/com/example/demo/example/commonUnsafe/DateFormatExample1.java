package com.example.demo.example.commonUnsafe;

import com.example.demo.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName DateFormatExample1
 * @Description DateFormat不是线程安全的类，尽量在方法中作为局部变量使用
 * @Author miaoxu
 * @Date 2019/7/26 22:34
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class DateFormatExample1 {

//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    //请求总数
    public static int clientTotal = 5000;
    //同时请求的线程数量
    public static int threadTotal = 200;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdownNow();
//        log.info("count:{}", stringBuffer.length());

    }

    public static void update()
    {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180209");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
