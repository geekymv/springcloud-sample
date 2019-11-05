package com.geekymv.springcloud.service;

import com.geekymv.common.api.BaseResponse;
import com.geekymv.common.exception.ServiceException;
import com.geekymv.springcloud.api.ProductApi;
import com.geekymv.springcloud.dto.response.ProductDetailResponse;
import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductService implements ProductApi {

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    @Override
    public BaseResponse createProduct(@RequestBody Product product) {


        return null;
    }

    @GetMapping("/detail/{productId}")
    @Override
    public ProductDetailResponse productDetail(@PathVariable Long productId) {
        log.info("productDetail productId = {}", productId);
        Product product = productMapper.findProductById(productId);
        ProductDetailResponse response = new ProductDetailResponse();
        if(product == null) {
            throw new ServiceException(productId + "产品不存在");
        }
        response.setProduct(product);
        return response;
    }
}
