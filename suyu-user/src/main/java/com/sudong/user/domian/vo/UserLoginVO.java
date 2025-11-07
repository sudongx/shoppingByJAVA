package com.sudong.user.domian.vo;


import lombok.Data;

@Data

//后端处理完毕后，返回给前端的参数
public class UserLoginVO {
    private String token;
    private String username;
    private Integer active;
}
