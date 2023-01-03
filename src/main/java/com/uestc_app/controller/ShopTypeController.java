package com.uestc_app.controller;


import com.uestc_app.dto.Result;
import com.uestc_app.entity.ShopType;
import com.uestc_app.service.IShopTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>

 */
@RestController
@RequestMapping("/shop-type")
public class ShopTypeController {
    @Resource
    private IShopTypeService typeService;
    @GetMapping("list")
    public Result queryTypeList() {
        return typeService.queryShopList();
    }
}
