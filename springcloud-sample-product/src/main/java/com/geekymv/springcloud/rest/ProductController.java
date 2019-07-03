package com.geekymv.springcloud.rest;

import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productDetail/{id1}")
    public Product productDetail(@PathVariable("id1") Long id) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10000; i++) {
            int temp = i;
            executorService.execute(()-> {
                Product product = productService.findProductById(id);
                System.out.println("productName = " + product.getProductName() + ", i = " + temp);
            });
        }
        return null;
    }

    @PostMapping(value = "/addProduct")
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product);
        return product;
    }

}
