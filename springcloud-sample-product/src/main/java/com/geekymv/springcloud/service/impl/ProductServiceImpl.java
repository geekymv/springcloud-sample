package com.geekymv.springcloud.service.impl;

import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findProductById(Long productId) {
        return productMapper.findProductById(productId);
    }
}
