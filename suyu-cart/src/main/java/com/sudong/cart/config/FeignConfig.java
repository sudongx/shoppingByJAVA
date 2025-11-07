package com.sudong.cart.config;

import com.sudong.api.domain.vo.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("product-list")
public interface FeignConfig {
    //根据id查找商品
    @PostMapping("/product/list")
    ProductVO seachProductListById(Long productDTO);
}
