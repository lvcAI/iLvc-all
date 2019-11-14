package me.ilvc.all.novel.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.Results;
import me.ilvc.all.common.model.novel.NovelInfo;
import me.ilvc.all.common.model.novel.Subscribe;
import me.ilvc.all.common.model.novel.User;
import me.ilvc.all.novel.feign.NovelUserFeignClient;
import me.ilvc.all.novel.service.INovelInfoService;
import me.ilvc.all.novel.service.ISubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Slf4j
@RestController
//@RequestMapping("/iLvc-novel")
public class SubscribeController {


    @Autowired
    private ISubscribeService subscribeService;

    @Autowired
    private INovelInfoService novelInfoService;

    @Autowired
    private NovelUserFeignClient novelUserFeignClient;


    @PostMapping(value = {"/subscriptions"})
    public Result subscriptions(@RequestParam int novelid, @RequestParam String email, HttpServletRequest request, HttpServletResponse response) {
        return subscribeService.addSubcriber(novelid,email);
    }


    // 获取所有的订阅列表
    @GetMapping(path = "/subscriptions")
    public Results<Subscribe> getAllSubscriptions() {

        Results<Subscribe> results = new Results();
        List<Subscribe> subscribes = subscribeService.list();
        if (subscribes == null || subscribes.size() == 0) {
            results.setCode(400);
            results.setMsg("未知错误！");
        } else {
            results.setCode(200);
            results.setMsg("加载成功！");
            results.setData(subscribes);
        }
        return results;
    }
}
