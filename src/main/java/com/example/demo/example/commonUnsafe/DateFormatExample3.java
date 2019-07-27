package com.example.demo.example.commonUnsafe;

import com.example.demo.annotations.NotThreadSafe;
import com.example.demo.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * @ClassName DateFormatExample3
 * @Description 验证joda包中的DateTimeFormatter具有线程安全性
 * @Author miaoxu
 * @Date 2019/7/26 22:34
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class DateFormatExample3 {

//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    //请求总数
    public static int clientTotal = 5000;
    //同时请求的线程数量
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = org.joda.time.format.DateTimeFormat.forPattern("yyyyMMdd");


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update(count);
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

    public static void update(int i)
    {
        try {
            log.info("{}， {}",i, DateTime.parse("20180209", dateTimeFormatter).toDate());
//            dateTimeFormatter.parse("20180209");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
