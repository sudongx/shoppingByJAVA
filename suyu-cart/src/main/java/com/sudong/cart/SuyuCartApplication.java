package com.sudong.cart;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan({"com.sudong.cart.mapper", "com.sudong.api.mapper"})
@EnableFeignClients //启用远程调用客户端
public class SuyuCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuyuCartApplication.class, args);
    }

}
