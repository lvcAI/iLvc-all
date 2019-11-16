package me.ilvc.all.novel.controller;


import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.NovelInfo;
import me.ilvc.all.novel.service.INovelInfoService;
import me.ilvc.all.novel.vo.NovelInfoParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/novels")
//@CrossOrigin
public class NovelInfoController {


    @Autowired
    private INovelInfoService novelInfoService;



    @GetMapping(path = {"/{id}","/{id}/"})
    public Result<NovelInfoParam> getById(@PathVariable("id")Integer id){
        NovelInfoParam novelInfoParam = new NovelInfoParam();
        BeanUtils.copyProperties(novelInfoService.getById(id),novelInfoParam);
        return Result.okWithData(novelInfoParam);
    }

    @GetMapping(path = {"/v1/{id}","/{id}/"})
    public Result<NovelInfo> getById2(@PathVariable("id")Integer id){
        return Result.okWithData(novelInfoService.getById(id));
    }
}
