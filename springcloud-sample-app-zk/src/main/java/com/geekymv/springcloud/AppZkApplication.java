package com.geekymv.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppZkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppZkApplication.class, args);
    }
}
