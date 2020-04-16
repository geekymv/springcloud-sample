package com.geekymv.springcloud.listener;

import com.geekymv.springcloud.threadpool.RequestProcessorThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("业务初始化");
        RequestProcessorThreadPool.init();
    }
}
