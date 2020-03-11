package com.geekymv.springcloud.controller;

import com.geekymv.common.model.Result;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Result createProduct(@RequestBody Product product) {

        return null;
    }

    @GetMapping("/detail/{productId}")
    public Product productDetail(@PathVariable Long productId) {
        log.info("productDetail productId = {}", productId);
        Product product = productService.findProductById(productId);
        return product;
    }
}
