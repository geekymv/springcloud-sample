package com.geekymv.springcloud.service;

import com.geekymv.springcloud.api.ProductApi;
import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductService implements ProductApi {

    @Resource
    private ProductMapper productMapper;

    @GetMapping("/detail/{productId}")
    @Override
    public Product productDetail(@PathVariable Long productId) {
        log.info("productDetail productId = {}", productId);
        return productMapper.findProductById(productId);
    }
}
