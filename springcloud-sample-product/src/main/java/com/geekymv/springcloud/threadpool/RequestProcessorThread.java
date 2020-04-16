package com.geekymv.springcloud.threadpool;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

@Slf4j
public class RequestProcessorThread implements Callable<Boolean> {

    private ArrayBlockingQueue<Request> queue;

    public RequestProcessorThread(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {
        while (true) {
            Request request = queue.take();
            log.debug("从队列中获取任务 type = {}, request = {}", request.getClass().getSimpleName(), JSON.toJSONString(request));
            request.process();
        }
    }
}
