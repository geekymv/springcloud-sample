package com.geekymv.springcloud.rest;

import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productDetail/{id1}")
    public Product productDetail(@PathVariable("id1") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping(value = "/addProduct")
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product);
        return product;
    }

}
