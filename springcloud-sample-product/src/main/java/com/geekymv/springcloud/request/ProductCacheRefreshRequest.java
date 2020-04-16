package com.geekymv.springcloud.request;

import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import com.geekymv.springcloud.threadpool.Request;

public class ProductCacheRefreshRequest implements Request {

    private Long productId;

    private ProductService productService;

    public ProductCacheRefreshRequest(Long productId, ProductService productService) {
        this.productId = productId;
        this.productService = productService;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public void process() {
        Product product = productService.findProductById(productId);
        productService.setProductInventoryCache(product);
    }
}
