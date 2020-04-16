package com.geekymv.springcloud.mapper;

import com.geekymv.springcloud.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    Product findProductById(@Param("productId") Long productId);

    /**
     * 更新产品库存
     * @param product
     */
    void updateProductInventoryCnt(Product product);
}
