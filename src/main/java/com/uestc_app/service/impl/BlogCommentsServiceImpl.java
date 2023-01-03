package com.uestc_app.service.impl;

import com.uestc_app.entity.BlogComments;
import com.uestc_app.mapper.BlogCommentsMapper;
import com.uestc_app.service.IBlogCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements IBlogCommentsService {

}
