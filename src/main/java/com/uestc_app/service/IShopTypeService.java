package com.uestc_app.service;

import com.uestc_app.dto.Result;
import com.uestc_app.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IShopTypeService extends IService<ShopType> {
    Result queryShopList();

//    Result getList();
}
