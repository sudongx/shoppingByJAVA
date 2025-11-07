package com.sudong.cart.domain.po;

import lombok.Data;

@Data
public class CartPO {
    private Integer productId;
    private Integer quantity;
    private String createTime;

}
