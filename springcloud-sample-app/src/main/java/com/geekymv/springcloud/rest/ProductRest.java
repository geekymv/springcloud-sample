package com.geekymv.springcloud.rest;

import com.geekymv.springcloud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductRest {

    private static final String PRODUCT_SERVICE_URL = "http://PRODUCT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductDetail/{productId}")
    public Product getProductDetail(@PathVariable Long productId) {
        return restTemplate.getForObject(PRODUCT_SERVICE_URL + "/productDetail/" + productId, Product.class);
    }

}
