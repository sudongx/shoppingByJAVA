package com.sudong.api.service.impl;


import com.sudong.api.domain.dto.ProductDTO;
import com.sudong.api.domain.po.ProductPO;
import com.sudong.api.domain.vo.ProductVO;
import com.sudong.api.mapper.ProductMapper;
import com.sudong.api.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVO seachList(ProductDTO productDTO) {
        //获取前端传递的id
        Long productId = productDTO.getId();

        //健壮性判断，不为空继续进行下一步
        if (productDTO == null || productDTO.getId() == null) {
            log.info("商品 ID 不能为空");
            return null;
        }

        //根据id到数据库进行匹配
        ProductPO productinfo = productMapper.seachListById((long) productId);

        if (productinfo != null){
            //打包返回实体类对象
            ProductVO vo = new ProductVO();
            vo.setProductName(productinfo.getProductName());  //商品的名称
            vo.setPrice(productinfo.getPrice()); //商品的价格
            vo.setImage(productinfo.getImage()); //商品的图像
            vo.setDescription(productinfo.getDescription());  //商品的描述
            vo.setInventory(productinfo.getInventory());  //商品的库存
            return vo;
        }else{
            log.error("该商品不存在！");
        }

        return null;
    }
}
