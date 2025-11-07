package com.sudong.user.domian.po;

import lombok.Data;


//用户实体类，也是数据库内的所有参数
@Data
public class User {
    private String username;
    private String password;
    private Integer active;
    private String createTime;
    private String updateTime;
}
