package me.ilvc.all.novel.controller;


import me.ilvc.all.common.model.Result;
import me.ilvc.all.novel.entity.NovelInfo;
import me.ilvc.all.novel.service.INovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/novel")
public class NovelInfoController {


    @Autowired
    private INovelInfoService novelInfoService;



    @RequestMapping(path = {"/{id}","/{id}/"})
    public Result<NovelInfo> getById(@PathVariable("id")Integer id){
        Result<NovelInfo> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功！");
        result.setData(novelInfoService.getById(id));
        Map<Object, Object> extra = new HashMap<>();
        extra.put("type", "测试");
        return result;
    }

}
