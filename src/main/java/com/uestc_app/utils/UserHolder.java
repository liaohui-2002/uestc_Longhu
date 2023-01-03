package com.uestc_app.utils;
import com.uestc_app.dto.UserDTO;


/**
 * @author liaohui
 * ThreadLocal 工具类
 */
public class UserHolder {
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO userId){
        tl.set(userId);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
