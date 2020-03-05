package com.geekymv.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.geekymv.springcloud.mapper")
@SpringBootApplication
public class ProductApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
