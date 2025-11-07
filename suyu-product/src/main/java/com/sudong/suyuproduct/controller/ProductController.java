package com.sudong.suyuproduct.controller;


import com.sudong.suyuproduct.domain.dto.AddNewDTO;
import com.sudong.suyuproduct.domain.dto.ProductDTO;
import com.sudong.suyuproduct.domain.vo.ProductVO;
import com.sudong.suyuproduct.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;


    //获取全部商品列表
    @GetMapping("/all")
    public List<ProductVO> getAllProduct(){
        return productService.seachAllList();
    }

    //根据id查询商品
    @PostMapping("/list")
    public ProductVO seachProductListById(@RequestBody @Validated Long id){
        System.out.println(">>> 前端传来的 DTO = " + id);
        return productService.seachList(id);
    }

    //根据分类查询商品
    @PostMapping("/item")
    public List<ProductVO> seachProductListByFenlei(@RequestBody @Validated ProductDTO productDTO){
        System.out.println(">>> 前端传来的 DTO = " + productDTO);
        return productService.seachListByFenlei(productDTO);
    }


    //新增商品
    @PostMapping("/add")
    public Integer addProduct(@RequestBody @Validated AddNewDTO addNewDTO){
        return productService.addProduct(addNewDTO);
    }
}
