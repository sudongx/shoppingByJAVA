package com.sudong.suyuproduct.service.impl;

import com.sudong.suyuproduct.domain.dto.AddNewDTO;
import com.sudong.suyuproduct.domain.dto.ProductDTO;
import com.sudong.suyuproduct.domain.po.ProductPO;
import com.sudong.suyuproduct.domain.vo.ProductVO;
import com.sudong.suyuproduct.mapper.ProductMapper;
import com.sudong.suyuproduct.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVO seachList(Long id) {
        //获取前端传递的id
//        Long productId = productDTO.getId();

        //健壮性判断，不为空继续进行下一步
//        if (productDTO == null || productDTO.getId() == null) {
//            log.info("商品 ID 不能为空");
//            return null;
//        }

        //根据id到数据库进行匹配
        ProductPO productinfo = productMapper.seachListById(id);

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

    //根据分类查找商品
    @Override
    public List<ProductVO> seachListByFenlei(ProductDTO productDTO) {
        Integer fenlei = productDTO.getFenlei();
        List<ProductPO> po = productMapper.seachListByfenlei(fenlei);

        if (po.isEmpty()){
            log.info("用户查询的分类中没有任何数据");
            return null;
        }

        log.info("用户查找{}分类成功",po.get(5).toString());
        return po.stream().map(po1 -> {
            ProductVO vo = new ProductVO();
            vo.setId(po1.getId());
            vo.setProductName(po1.getProductName()); //商品的名称
            vo.setPrice(po1.getPrice()); //商品的价格
            vo.setImage(po1.getImage()); //商品的图像
            vo.setDescription(po1.getDescription()); //商品的描述
            vo.setInventory(po1.getInventory()); //商品的库存
            vo.setFenlei(po1.getFenlei()); //商品分类
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductVO> seachAllList() {
        //查找数据库
        List<ProductPO> allList = productMapper.seachAllList();

        List<ProductVO> voList = allList.stream()
                .map(po -> {
                    ProductVO vo = new ProductVO();
                    vo.setId(po.getId());
                    vo.setProductName(po.getProductName()); //商品的名称
                    vo.setPrice(po.getPrice()); //商品的价格
                    vo.setImage(po.getImage()); //商品的图像
                    vo.setDescription(po.getDescription()); //商品的描述
                    vo.setInventory(po.getInventory()); //商品的库存
                    vo.setFenlei(po.getFenlei()); //商品分类
                    return vo;
                })
                .collect(Collectors.toList());

        return voList;
    }

    //新增商品
    @Override
    public Integer addProduct(AddNewDTO addNewDTO) {
        //获取前端传递的所有对象
        String productName = addNewDTO.getProductName();
        float price = addNewDTO.getPrice();
        String des = addNewDTO.getDescription();
        String image = addNewDTO.getImage();
        Integer inventory = addNewDTO.getInventory();

        //创建时间
        long timeMillis = System.currentTimeMillis();
        java.sql.Timestamp createTime = new java.sql.Timestamp(timeMillis);

        //将所有字段存储到数据库
        int i = productMapper.addProduct(productName,price,des,image,inventory,createTime);
        return 0;
    }
}
