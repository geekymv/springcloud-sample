package com.geekymv.feign.fallback;

import com.geekymv.common.model.Result;
import com.geekymv.feign.ProductClient;
import com.geekymv.springcloud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductFallback implements ProductClient {

    @Override
    public Result<Product> createProduct(Product product) {
        return null;
    }

    @Override
    public Result<Product> productDetail(Long productId) {
        return null;
    }
}
