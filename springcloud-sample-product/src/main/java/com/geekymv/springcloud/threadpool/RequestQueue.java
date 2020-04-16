package com.geekymv.springcloud.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RequestQueue {

    private static List<ArrayBlockingQueue<Request>> queues = new ArrayList<>();

    private RequestQueue() {
    }

    private static class Singleton {
        private static RequestQueue instance;
        static {
            instance = new RequestQueue();
        }
        public static RequestQueue getInstance() {
            return instance;
        }
    }

    public static RequestQueue getInstance() {
        return Singleton.getInstance();
    }


    public void addQueue(ArrayBlockingQueue<Request> queue) {
        queues.add(queue);
    }

    /**
     * 获取内存队列数量
     * @return
     */
    public int size() {
        return queues.size();
    }

    public ArrayBlockingQueue<Request> getQueue(int index) {
        return queues.get(index);
    }

}
