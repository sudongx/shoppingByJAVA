package com.sudong.cart.domain.vo;

import lombok.Data;

@Data
//返回购物车数据
public class CartVO {
    private String userId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private String createTime;
    private String description;
    private float price;
    private String image;
    private Integer inventory;
    private Integer fenlei;
}
