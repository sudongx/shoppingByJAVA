package com.sudong.api.service;



import com.sudong.api.domain.dto.ProductDTO;
import com.sudong.api.domain.vo.ProductVO;

import java.util.List;

public interface IProductService {
    //根据id查找商品
    ProductVO seachList(ProductDTO productDTO);

}
