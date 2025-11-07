package com.sudong.cart.service;

import com.sudong.cart.domain.dto.CartDTO;
import com.sudong.cart.domain.dto.PutDTO;
import com.sudong.cart.domain.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICartService {
    //添加购物车
    Integer addItem(CartDTO cartDTO);

    //根据id查询所有购物车数据
    List<CartVO> searchAllCartList(String id);

    //更新商品数量
    Integer upQuantity(PutDTO putDTO);

    //删除商品
    Integer remove(Map<String,Object> rem);
}
