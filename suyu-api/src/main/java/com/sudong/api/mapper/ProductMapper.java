package com.sudong.api.mapper;


import com.sudong.api.domain.po.ProductPO;
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
}
