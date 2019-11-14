package me.ilvc.all.blog.controller;


import me.ilvc.all.blog.mapper.BlogMapper;
import me.ilvc.all.blog.model.Blog;
import me.ilvc.all.blog.vo.BlogParam;
import me.ilvc.all.common.model.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author muger
 */
@RestController
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @PostMapping("/blog")
    public Result savePost(@RequestParam BlogParam blogParam) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogParam, blog);
        blogMapper.insert(blog);
        return Result.ok();
    }

    @GetMapping("/blog/{blogId}")
    public Result selectBlog(@PathVariable("blogId") Integer blogId) {
        //todo return a BlogDTO
        return Result.okWithData(blogMapper.selectById(blogId));
    }

    @PutMapping("/blog/{blogId}")
    public Result updateBlog(@PathVariable("blogId") Integer blogId, @RequestParam BlogParam blogParam) {

        return Result.ok();
    }

}
