package com.geekymv.springcloud.threadpool;

public interface Request {

    void process();

    Long getProductId();

}
