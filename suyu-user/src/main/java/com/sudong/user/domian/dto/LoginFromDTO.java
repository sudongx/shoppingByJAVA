package com.sudong.user.domian.dto;


import lombok.Data;


//接收用户前端传递的参数，封装在此
@Data
public class LoginFromDTO {
    private String username;
    private String password;
}
