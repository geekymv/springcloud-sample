package com.geekymv.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Product implements Serializable {

    private Long productId;

    private String productName;

}
