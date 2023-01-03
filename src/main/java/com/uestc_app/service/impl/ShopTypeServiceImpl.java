package com.uestc_app.service.impl;

import cn.hutool.json.JSONUtil;
import com.uestc_app.dto.Result;
import com.uestc_app.entity.ShopType;
import com.uestc_app.mapper.ShopTypeMapper;
import com.uestc_app.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.uestc_app.utils.RedisConstants.CACHE_SHOP_TYPE_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryShopList() {
        // 1. 从redis中查询商铺类型列表
        List<String> shopTypes = stringRedisTemplate.opsForList().range(CACHE_SHOP_TYPE_KEY, 0, 9);
        // 2. 命中，返回商铺类型信息
        List<ShopType> shopTypesByRedis = new ArrayList<>();
        if (shopTypes.size() != 0) {
            for (String shopType : shopTypes) {
                ShopType type = JSONUtil.toBean(shopType, ShopType.class);
                shopTypesByRedis.add(type);
            }
            return Result.ok(shopTypesByRedis);
        }
        // 3. 未命中，从数据库中查询商铺类型,并根据sort排序
        List<ShopType> shopTypesByMysql = query().orderByAsc("sort").list();
        // 4. 将商铺类型存入到redis中
        for (ShopType shopType : shopTypesByMysql) {
            String s = JSONUtil.toJsonStr(shopType);
            stringRedisTemplate.opsForList().rightPushAll(CACHE_SHOP_TYPE_KEY,s);
        }
        // 5. 返回商铺类型信息
        return Result.ok(shopTypesByMysql);
    }
  /*  @Override
    public Result getList() {
        String key = "cache:typelist";
        List<String> shopTypeList = new ArrayList<>();
        //1.从redis查询商铺缓存
        shopTypeList = stringRedisTemplate.opsForList().range(key,0,-1);
        //2.判断是否存在
        if(!shopTypeList.isEmpty()){
            //3.存在就返回
          List<ShopType> typeList = new ArrayList<>();
            for (String s : shopTypeList) {
                ShopType shopType =  JSONUtil.toBean(s,ShopType.class);
                typeList.add(shopType);
            }
            return  Result.ok(typeList);
        }


        //4根据id查询数据库
        List<ShopType> typeList = query().orderByAsc("sort").list();
        //5.不存在返回错误
        if (typeList.isEmpty()) {
            return Result.fail("不存在该类店铺");
        }
        for (ShopType shopType : typeList) {
            String s = JSONUtil.toJsonStr(shopType);
            shopTypeList.add(s);
        }
        //6.存在 写入redis
       stringRedisTemplate.opsForList().rightPushAll(key,shopTypeList);
        //7.返回
        return Result.ok(typeList);
    }*/
}
