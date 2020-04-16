package com.geekymv.springcloud.controller;

import com.geekymv.common.model.Result;
import com.geekymv.springcloud.model.Product;
import com.geekymv.springcloud.request.ProductCacheRefreshRequest;
import com.geekymv.springcloud.request.ProductDBUpdateRequest;
import com.geekymv.springcloud.service.ProductService;
import com.geekymv.springcloud.service.RequestAsyncProcessService;
import com.geekymv.springcloud.threadpool.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private RequestAsyncProcessService requestAsyncProcessService;

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Result createProduct(@RequestBody Product product) {

        return null;
    }

    @GetMapping("/getProductCache/{productId}")
    public Product getProductCache(@PathVariable Long productId) {
        log.info("productDetail productId = {}", productId);
        Product product = null;

        long startTime = System.currentTimeMillis();
        long waitTime = 10000; // 1s

        // 是否需要发起加载产品库存缓存的任务
        boolean productCacheRefresh = true;

        do {
            if(System.currentTimeMillis() - startTime > waitTime) {
                log.debug("超过1s没有从缓存中读取到产品库存");
                break;
            }

            product = productService.getProductCache(productId);
            if(product != null) {
                log.debug("从缓存中读取到产品库存");
                break;
            }
            if(productCacheRefresh) {
                log.info("发起加载产品库存缓存的任务");
                productCacheRefresh = false;
                Request request = new ProductCacheRefreshRequest(productId, productService);
                requestAsyncProcessService.process(request);
            }

            // 从缓存中没有读取到产品库存，等待20ms 再次从缓存中查询
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }

        }while (product == null);

        if(product == null) {
            log.info("从数据库中读取产品库存");
            product = productService.findProductById(productId);
        }
        return product;
    }

    @PostMapping("/updateProductInventoryCnt")
    public Result updateProductInventoryCnt(@RequestBody Product product) {
        Request request = new ProductDBUpdateRequest(product, productService);
        requestAsyncProcessService.process(request);
        return Result.success(null);
    }
}
