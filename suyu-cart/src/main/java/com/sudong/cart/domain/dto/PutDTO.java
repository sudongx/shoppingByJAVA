package com.sudong.cart.domain.dto;

import lombok.Data;

@Data
public class PutDTO {
    private String userId;  //用户id
    private Integer productId;  //商品id
    private Integer  active;   //加减状态 1标识增加 0减少
}
