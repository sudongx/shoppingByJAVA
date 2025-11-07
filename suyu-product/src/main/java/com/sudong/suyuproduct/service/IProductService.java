package com.sudong.suyuproduct.service;

import com.sudong.suyuproduct.domain.dto.AddNewDTO;
import com.sudong.suyuproduct.domain.dto.ProductDTO;
import com.sudong.suyuproduct.domain.vo.ProductVO;

import java.util.List;

public interface IProductService {
    //根据id查找商品
    ProductVO seachList(Long id);

    //根据分类查找商品
    List<ProductVO> seachListByFenlei(ProductDTO productDTO);

    //查找所有的商品
    List<ProductVO> seachAllList();

    //新增商品
    Integer addProduct(AddNewDTO addNewDTO);
}
