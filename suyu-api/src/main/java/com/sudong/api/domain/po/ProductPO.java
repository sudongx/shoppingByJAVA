package com.sudong.api.domain.po;

import lombok.Data;

@Data
public class ProductPO {
    private String id;
    private String productName;
    private String description;
    private float price;
    private String createTime;
    private String updateTime;
    private String image;
    private Integer inventory;
    private Integer fenlei;
}
