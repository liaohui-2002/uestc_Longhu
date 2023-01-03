package com.uestc_app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uestc_app.dto.LoginFormDTO;
import com.uestc_app.dto.Result;
import com.uestc_app.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
