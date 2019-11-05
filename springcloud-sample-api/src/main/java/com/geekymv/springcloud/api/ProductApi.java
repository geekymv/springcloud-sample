package com.geekymv.springcloud.api;

import com.geekymv.springcloud.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductApi {

    @GetMapping(value = "/product/detail/{productId}")
    Product productDetail(@PathVariable("productId") Long productId);
}
