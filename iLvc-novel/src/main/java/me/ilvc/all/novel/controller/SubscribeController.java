package me.ilvc.all.novel.controller;


import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.User;
import me.ilvc.all.novel.feign.NovelUserFeignClient;
import me.ilvc.all.novel.service.ISubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
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
@RequestMapping("/iLvc-novel")
public class SubscribeController {


    @Autowired
    private ISubscribeService subscribeService;

    @Autowired
    private NovelUserFeignClient novelUserFeignClient;


    @PostMapping(value = {"/subscriptions"})
    public Result subscriptions(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("URL:" + request.getRequestURL());
        // 天呐 ，获取参数的的方法都忘了，还是以为是属性
        String novelid = request.getParameter("novelid").toString();
        String email = request.getParameter("email").toString();

        System.out.println(request.getRequestURL() + " email: " + email + " novelid: " + novelid);
        // 查询用户
        Result<User> novel_user_result=novelUserFeignClient.getUserByEmail(email);
        System.out.println(novel_user_result);
        Result result = new Result();
        Map<Object, Object> map = new HashMap<>();
        map.put("novelid", novelid);
        map.put("email", email);
        result.setData(novel_user_result.getData());
        result.setExtra(map);
        return result;
    }
}
