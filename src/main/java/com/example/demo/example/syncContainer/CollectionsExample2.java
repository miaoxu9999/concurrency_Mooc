package com.example.demo.example.syncContainer;

import com.example.demo.annotations.ThreadSafe;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName CollectionsExample2
 * @Description 验证 Collections.synchronizedSet是同步容器
 * @Author miaoxu
 * @Date 2019/7/26 22:34
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class CollectionsExample2 {

//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    //请求总数
    public static int clientTotal = 5000;
    //同时请求的线程数量
    public static int threadTotal = 200;

    private static Set<Integer> list = Collections.synchronizedSet(Sets.newHashSet());


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
        log.info("count:{}", list.size());

    }

    public static void update(int i)
    {
        try {
            list.add(i);
//            dateTimeFormatter.parse("20180209");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
