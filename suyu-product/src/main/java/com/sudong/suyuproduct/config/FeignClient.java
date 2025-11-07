package com.sudong.suyuproduct.config;

import com.sudong.suyuproduct.domain.dto.ProductDTO;
import com.sudong.suyuproduct.domain.vo.ProductVO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@EnableFeignClients
public interface FeignClient {

//    //根据id查找商品
//    @PostMapping("/getList")
//    public ProductVO seachProductListById(@RequestBody @Validated ProductDTO productDTO);
}
