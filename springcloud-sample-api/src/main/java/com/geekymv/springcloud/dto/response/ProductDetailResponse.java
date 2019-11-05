package com.geekymv.springcloud.dto.response;

import com.geekymv.common.BaseResponse;
import com.geekymv.springcloud.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Builder
public class ProductDetailResponse extends BaseResponse {

    private Product product;

}
