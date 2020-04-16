package com.geekymv.springcloud.request;

import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import com.geekymv.springcloud.threadpool.Request;

public class ProductDBUpdateRequest implements Request {

    private Product product;

    private ProductService productService;

    public ProductDBUpdateRequest(Product product, ProductService productService) {
        this.product = product;
        this.productService = productService;
    }

    @Override
    public Long getProductId() {
        return product.getProductId();
    }

    @Override
    public void process() {
        productService.updateProductInventoryCnt(product);
    }
}
