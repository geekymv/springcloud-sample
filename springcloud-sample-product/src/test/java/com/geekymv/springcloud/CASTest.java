package com.geekymv.springcloud;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    private AtomicInteger count = new AtomicInteger(0);

    public int incrementAndGet() {
        int current = count.get();
        int next = (current + 1) % 10;
        for(;;) {
            if(count.compareAndSet(current, next)) {
                return next;
            }
        }
    }


    @Test
    public void testIncrementAndGet() {
        CASTest casTest = new CASTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(100);
        for(int i = 0; i < 100; i++) {
            executorService.execute(()-> {
                try {
                    int res = casTest.incrementAndGet();
                    System.out.println("res = " + res);
                }finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
