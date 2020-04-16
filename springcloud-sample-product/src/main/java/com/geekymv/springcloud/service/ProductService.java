package com.geekymv.springcloud.service;

import com.geekymv.common.model.Constants;
import com.geekymv.springcloud.mapper.ProductMapper;
import com.geekymv.springcloud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CacheService cacheService;

//    @Cacheable(cacheNames = "products",key = "#productId")
    public Product findProductById(Long productId) {
        return productMapper.findProductById(productId);
    }

    /**
     * 更新产品库存
     * @param product
     */
    public void updateProductInventoryCnt(Product product) {
        // 删除缓存
        String key = Constants.Cache.PROCUCT_INVENTORY + Constants.COLON + product.getProductId();
        cacheService.delete(key);

        // 更新数据库
        productMapper.updateProductInventoryCnt(product);
    }


    /**
     * 从缓存中读取产品库存
     * @param productId
     * @return
     */
    public Product getProductCache(Long productId) {
        String key = Constants.Cache.PROCUCT_INVENTORY + Constants.COLON + productId;
        return (Product)cacheService.get(key);
    }

    /**
     * 设置产品库存缓存
     * @param product
     */
    public void setProductInventoryCache(Product product) {
        String key = Constants.Cache.PROCUCT_INVENTORY + Constants.COLON + product.getProductId();
        log.debug("设置产品库存缓存 key = {}", key);
        cacheService.set(key, product);
    }
}
