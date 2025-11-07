package com.sudong.suyuproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.sudong.suyuproduct.mapper")
@EnableFeignClients //启用远程调用
public class SuyuProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuyuProductApplication.class, args);
    }

}
