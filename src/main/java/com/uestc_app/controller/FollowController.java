package com.uestc_app.controller;


import com.uestc_app.dto.Result;
import com.uestc_app.service.IFollowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/follow")
public class FollowController {
    // id  remain version
    // 1     1        1      原始数据
    // 1     1        1       a
    // 1     1        1       b

    // 1     0        2       a在更新数据的时候更新版本号+1

    // 1     0-1      1       id=1，这条数据version=2，更新不成功

    @Resource
    private IFollowService followService;

    //关注
    @PutMapping("/{id}/{isFollow}")
    public Result follow(@PathVariable("id") Long followUserId, @PathVariable("isFollow") Boolean isFollow) {
        return followService.follow(followUserId, isFollow);
    }
    //取消关注
    @GetMapping("/or/not/{id}")
    public Result isFollow(@PathVariable("id") Long followUserId) {
        return followService.isFollow(followUserId);
    }

    /**
     * 共同关注
     * @param id
     * @return
     */
    @GetMapping("/common/{id}")
    public Result followCommons(@PathVariable("id") Long id){
        return followService.followCommons(id);
    }

}
