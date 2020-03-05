package com.geekymv.springcloud.controller;

import com.geekymv.springcloud.api.ProductApi;
import com.geekymv.common.api.CommonResult;
import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController implements ProductApi {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public CommonResult createProduct(@RequestBody Product product) {

        return null;
    }

    @GetMapping("/detail/{productId}")
    public CommonResult<Product> productDetail(@PathVariable Long productId) {
        log.info("productDetail productId = {}", productId);
        Product product = productService.findProductById(productId);
        return new CommonResult<Product>(200, "请求成功",product);
    }
}
