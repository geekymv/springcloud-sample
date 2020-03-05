package com.geekymv.springcloud.service;

import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private ModelMapper modelMapper;


    public Product findProductById(Long productId) {
        return productMapper.findProductById(productId);
    }
}
