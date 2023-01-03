package com.uestc_app.service.impl;

import com.uestc_app.entity.UserInfo;
import com.uestc_app.mapper.UserInfoMapper;
import com.uestc_app.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
