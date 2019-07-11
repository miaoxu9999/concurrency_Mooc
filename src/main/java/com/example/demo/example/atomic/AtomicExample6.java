package com.example.demo.example.atomic;

import com.example.demo.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName AtomicExample6
 * @Description AtomicBoolean让某些操作只执行一次
 * @Author miaoxu
 * @Date 2019/7/11 13:50
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class AtomicExample6 {
    private static AtomicBoolean isHappened = new AtomicBoolean();

    //请求总数
    public static int clientTotal = 5000;
    //同时请求的线程数量
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService  = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    test();
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
        log.info("isHappened{}", isHappened);

    }

    public static void test()
    {
        if (isHappened.compareAndSet(false, true))
        {
            log.info("execute");
        }
    }
}
