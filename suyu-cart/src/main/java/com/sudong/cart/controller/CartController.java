package com.sudong.cart.controller;

import com.sudong.cart.domain.dto.CartDTO;
import com.sudong.cart.domain.dto.PutDTO;
import com.sudong.cart.domain.vo.CartVO;
import com.sudong.cart.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final ICartService cartService;

    //新增商品
    @PostMapping("/add")
    Integer addItem(@RequestBody @Validated CartDTO cartDTO){
        log.info("接收到前端传递的参数,",cartDTO);
        return cartService.addItem(cartDTO);
    }

    //查询购物车
    @GetMapping("/search")
    public List<CartVO> searchCart(@RequestParam String id) {
        return cartService.searchAllCartList(id);
    }

    //数量管理
    @PutMapping("/upquantity")
    public Integer upquantity(@RequestBody @Validated PutDTO putDTO){
        return cartService.upQuantity(putDTO);
    }

    //删除商品
    @DeleteMapping("/remove")
    public Integer removeCart(@RequestBody Map<String,Object>  rem){
        return cartService.remove(rem);
    }
}
