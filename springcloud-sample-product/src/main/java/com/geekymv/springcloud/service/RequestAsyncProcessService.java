package com.geekymv.springcloud.service;

import com.geekymv.springcloud.threadpool.Request;
import com.geekymv.springcloud.threadpool.RequestQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Slf4j
@Service
public class RequestAsyncProcessService {

    public void process(Request request) {
        BlockingQueue<Request> queue = this.route(request.getProductId());
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    private BlockingQueue<Request> route(Long productId) {
        String key = String.valueOf(productId);
        RequestQueue requestQueue = RequestQueue.getInstance();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (requestQueue.size()-1) & hash;

        log.info("route index = {}", index);
        return requestQueue.getQueue(index);
    }
}
