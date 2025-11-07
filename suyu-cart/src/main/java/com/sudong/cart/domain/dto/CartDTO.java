package com.sudong.cart.domain.dto;

import lombok.Data;

@Data
public class CartDTO {
    private String userId;  //用户id
    private Integer productId;  //商品id
    private Integer  quantity;   //数量
}
