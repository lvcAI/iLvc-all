package me.ilvc.all.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.ilvc.all.blog.model.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
}