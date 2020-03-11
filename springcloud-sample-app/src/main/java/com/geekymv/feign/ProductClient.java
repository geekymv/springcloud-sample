package com.geekymv.feign;

import com.geekymv.common.model.Result;
import com.geekymv.feign.fallback.ProductFallback;
import com.geekymv.springcloud.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", path = "/product", fallback = ProductFallback.class)
public interface ProductClient {

    @PostMapping("/create")
    Result<Product> createProduct(@RequestBody Product product);

    @GetMapping(path = "/detail/{productId}")
    Result<Product> productDetail(@PathVariable("productId") Long productId);
}
