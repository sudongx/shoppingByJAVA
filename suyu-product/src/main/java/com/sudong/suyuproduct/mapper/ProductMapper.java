package com.sudong.suyuproduct.mapper;

import com.sudong.suyuproduct.domain.po.ProductPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ProductMapper {
    //根据id来查找商品
    @Select("select * FROM product WHERE id = #{id}")
    ProductPO seachListById(@Param("id") Long id);

    //查找商品分类
    @Select("select * FROM product WHERE fenlei = #{fenlei}")
    List<ProductPO> seachListByfenlei(@Param("id") Integer fenlei);

    //查找所有的商品
    @Select("select * FROM product")
    List<ProductPO> seachAllList();

    //新增商品
    @Insert("insert product_name,description,price,create_time,image,inventory " +
            "into product values (#{productName},#{des},#{price},#{createTime},#{image},#{inventory})")
    int addProduct(String productName, float price, String des, String image, Integer inventory, Timestamp createTime);
}
