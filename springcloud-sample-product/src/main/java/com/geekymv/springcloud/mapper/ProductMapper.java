package com.geekymv.springcloud.mapper;

import com.geekymv.springcloud.aspect.DataSource;
import com.geekymv.springcloud.enums.DataSourceType;
import com.geekymv.springcloud.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    @DataSource(DataSourceType.SLAVE)
    Product findProductById(@Param("productId") Long productId);
}
