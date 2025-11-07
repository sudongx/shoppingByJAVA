package com.sudong.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sudong.user.mapper")
public class SuyuUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuyuUserApplication.class, args);
    }

}
