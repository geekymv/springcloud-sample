package com.geekymv.springcloud.rest;

import com.geekymv.common.model.Result;
import com.geekymv.feign.ProductClient;
import com.geekymv.springcloud.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductRest {

    @Resource
    private ProductClient productApi;

    @GetMapping("/getProductDetail/{productId}")
    public Result<Product> getProductDetail(@PathVariable Long productId) {
        return productApi.productDetail(productId);
    }

}
