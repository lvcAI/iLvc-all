package me.ilvc.all.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.ilvc.all.blog.mapper.BlogMapper;
import me.ilvc.all.blog.model.Blog;
import me.ilvc.all.blog.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
