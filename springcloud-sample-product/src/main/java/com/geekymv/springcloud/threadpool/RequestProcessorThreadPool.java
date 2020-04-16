package com.geekymv.springcloud.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestProcessorThreadPool {

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private RequestProcessorThreadPool() {
        for(int i = 0; i < 10; i++) {
            ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
            RequestQueue.getInstance().addQueue(queue);

            threadPool.submit(new RequestProcessorThread(queue));
        }
    }

    /**
     * jvm机制保证多线程并发安全
     * 内部类的初始化，只会发生一次。
     */
    private static class Singleton {
        private static RequestProcessorThreadPool instance;
        static {
            instance = new RequestProcessorThreadPool();
        }
        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }

    public static RequestProcessorThreadPool getInstance() {
        return Singleton.getInstance();
    }

    public static void init() {
        getInstance();
    }

}
