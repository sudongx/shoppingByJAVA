package com.sudong.suyuproduct.domain.vo;


import lombok.Data;

@Data
public class ProductVO {
    private String id; //商品id
    private String productName;
    private String description;
    private float price;
    private String image;
    private Integer inventory;
    private Integer fenlei;
}
