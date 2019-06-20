package com.geekymv.springcloud.service;

import com.geekymv.springcloud.model.Product;

public interface ProductService {

    Product findProductById(Long productId);
}
