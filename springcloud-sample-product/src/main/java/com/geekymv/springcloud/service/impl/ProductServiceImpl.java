package com.geekymv.springcloud.service.impl;

import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品信息
     * @Cacheable 除了第一次之外，一直取的是缓存的值
     * @param productId
     * @return
     */
    @Cacheable(cacheNames = "products", key = "#productId")
    @Override
    public Product findProductById(Long productId) {
        return productMapper.findProductById(productId);
    }

    /**
     * 将商品信息保存到本地缓存
     * @CachePut 注解用来将值改变并写入缓存中
     * @param product
     * @return
     */
    @CachePut(cacheNames = "products", key = "#product.productId")
    @Override
    public Product saveProduct2LocalCache(Product product) {
        return product;
    }
}
