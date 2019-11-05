package com.geekymv.springcloud.dto.response;

import com.geekymv.common.api.BaseResponse;
import com.geekymv.springcloud.model.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetailResponse extends BaseResponse {

    private Product product;

}
