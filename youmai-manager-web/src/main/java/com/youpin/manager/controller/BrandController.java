package com.youpin.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.youmai.pojo.TbBrand;
import com.youmai.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * @Description 返回分页列表
     * @Date 19:03 2018/9/10
     * @Param [pageNum, pageSize]
     * @return
     **/
    @RequestMapping("/findPage")
    public PageResult findPage(Integer page, Integer size) {
        PageResult tbBrands = brandService.findPage(page, size);
        return tbBrands;
    }

    /**
     * @Description 添加品牌
     * @Date 22:16 2018/9/10
     * @Param [tbBrand]
     * @return entity.Result
     **/
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand){
        try {
            brandService.add(tbBrand);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }
}
