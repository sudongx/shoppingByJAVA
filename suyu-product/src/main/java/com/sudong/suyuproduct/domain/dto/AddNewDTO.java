package com.sudong.suyuproduct.domain.dto;


import lombok.Data;

@Data
//新增商品对象
public class AddNewDTO {
    private String productName;
    private String description;
    private float price;
    private String image;
    private Integer inventory;
    private Integer fenlei;
}
