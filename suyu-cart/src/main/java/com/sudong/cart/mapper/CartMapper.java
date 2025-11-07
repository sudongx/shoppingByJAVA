package com.sudong.cart.mapper;

import com.sudong.cart.domain.po.CartPO;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CartMapper {
    //新增购物车内容
    @Insert("INSERT INTO cart(user_id, product_id, quantity, create_time) " +
            "VALUES (#{userId}, #{productId}, #{quantity}, #{nowTime})")
    Integer addNewItem(@Param("userId") String userId,
                       @Param("productId") Integer productId,
                       @Param("quantity") Integer quantity,
                       @Param("nowTime") Timestamp nowTime);


    @Select("select product_id, quantity, create_time FROM cart where user_id = #{id}")
    //根据用户id查询购物车
    List<CartPO> searchCart(@Param("id") String id);


    @Update("UPDATE cart SET quantity = quantity + 1, update_time = NOW() WHERE user_id = #{userId} AND product_id = #{productId}")
    //增加商品数量
    Integer upQuantity(@Param("userId") String userId,@Param("productId") Integer productId);

    //减少商品数量
    @Update("UPDATE cart SET quantity = quantity - 1, update_time = NOW() WHERE user_id = #{userId} AND product_id = #{productId}")
    Integer downQuantity(@Param("userId")String userId, @Param("productId")Integer productId);

    //删除商品
    @Delete("DELETE FROM cart WHERE user_id = #{userName} AND product_id = #{productId}")
    Integer removeCart(@Param("userName") String userName,@Param("productId") Integer productId);


}
