package me.ilvc.all.blog.service.impl;

import me.ilvc.all.blog.entity.TPost;
import me.ilvc.all.blog.mapper.PostMapper;
import me.ilvc.all.blog.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, TPost> implements IPostService {

}
