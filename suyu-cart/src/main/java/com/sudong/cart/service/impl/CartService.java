package com.sudong.cart.service.impl;


import com.sudong.api.domain.dto.ProductDTO;
import com.sudong.api.domain.po.ProductPO;
import com.sudong.api.domain.vo.ProductVO;
import com.sudong.api.mapper.ProductMapper;
import com.sudong.cart.config.FeignConfig;
import com.sudong.cart.domain.dto.CartDTO;
import com.sudong.cart.domain.dto.PutDTO;
import com.sudong.cart.domain.po.CartPO;
import com.sudong.cart.domain.vo.CartVO;
import com.sudong.cart.mapper.CartMapper;
import com.sudong.cart.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartMapper CartMapper;

    private final ProductMapper productMapper;

    @Resource
    private FeignConfig feignConfig;
    //新增购物车商品
    @Override
    public Integer addItem(CartDTO cartDTO) {
        String userId = cartDTO.getUserId(); //用户id
        Integer productId = cartDTO.getProductId(); //商品id
        Integer quantity = cartDTO.getQuantity(); //数量

        //获取当前时间
        long timeMillis = System.currentTimeMillis();
        Timestamp nowTime = new Timestamp(timeMillis);

        try {
            Integer i = CartMapper.addNewItem(userId, productId, quantity, nowTime);
            if (i != 0){
                log.info("商品成功添加到数据库");
                return 1;
            }
        }catch (Throwable SQLNonTransientException){
            log.error("数据库出错，数据不正确");
            return 0;
        }

        return null;
    }


    //根据Id查询购物车数据

    @Override
    public List<CartVO> searchAllCartList(String id) {
        //根据用户id查询购物车里的数据
        List<CartPO> cart = CartMapper.searchCart(id);

        //用购物车数组组装返回的vo对象
        List<CartVO> voList = cart.stream()
                .map(c -> {
                    //拿到购物车数据后，用商品id再向商品服务发送请求，获取商品的相关信息
//                    ProductDTO productDTO = new ProductDTO();
//                    productDTO.setId(Long.valueOf(c.getProductId()));
                    ProductVO po = feignConfig.seachProductListById(Long.valueOf(c.getProductId()));

                    //拿到商品信息之后可以开始组装vo
                    CartVO cartVO = new CartVO();
                    cartVO.setProductName(po.getProductName());  //商品名称
                    cartVO.setDescription(po.getDescription());  //商品描述
                    cartVO.setProductId(c.getProductId());  //商品id
                    cartVO.setFenlei(po.getFenlei());  //分类
                    cartVO.setImage(po.getImage());  //图像
                    cartVO.setCreateTime(c.getCreateTime()); //创建时间
                    cartVO.setInventory(po.getInventory()); //库存
                    cartVO.setPrice(po.getPrice());  //价格
                    cartVO.setQuantity(c.getQuantity()); //数量
                    return cartVO;
                })
                .collect(Collectors.toList());
        return voList;
    }

    //增加商品数量
    @Override
    public Integer upQuantity(PutDTO putDTO) {
    if(putDTO.getActive() == 1){
        //向数据库增加商品数量
        Integer upResult = CartMapper.upQuantity(putDTO.getUserId(),putDTO.getProductId());
        if (upResult == 0){

        }else{
            log.info("商品数据已更新成功，数量+1，影响了{}条数据",upResult);
            return 1;
        }
    }
    if (putDTO.getActive() == 0 ){
        Integer downResule = CartMapper.downQuantity(putDTO.getUserId(),putDTO.getProductId());
        if (downResule == 0 ){
            log.info("商品数据不存在");
            return 0;
        }else{
            log.info("商品数据已删除成功，数量-1，影响了{}条数据",downResule);
            return 1;
        }
    }
        return null;
    }

    @Override
    public Integer remove(Map<String , Object> rem) {
        String userName = rem.get("userName").toString();
        Integer productId = (Integer) rem.get("productId");

        //删除商品
        Integer removeResult = CartMapper.removeCart(userName, productId);
        if (removeResult != 0 ){
            log.info("商品数据已删除成功，删除了{}条数据",removeResult);
            return 1;
        }
        return null;
    }
}
