package me.ilvc.all.novel.controller;


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
 *  前端控制器
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
        // 最终返回 结果
        Result result = new Result();
        Subscribe subscribe;
        System.out.println("URL:" + request.getRequestURL());
        // 天呐 ，获取参数的的方法都忘了，还是以为是属性
//        String novelid = request.getParameter("novelid").toString();
//        String email = request.getParameter("email").toString();
        log.info("请求URL：{} email：{} novelid:{}",request.getRequestURL(),email,novelid);
        // 查询用户
        Result<User> novel_user_result=novelUserFeignClient.getUserByEmail(email);
        log.info(" 打印 novel_user_result ：{}",novel_user_result);
//        System.out.println(novel_user_result);
        // 查询 novelid 是否存在
        NovelInfo novelInfo = novelInfoService.getById(novelid);
        if (novelInfo == null) {
            result.setCode(404);
            result.setMsg("novelid:" + novelid + "不存在！");
            return result;
        } else {
                    subscribe = Subscribe.builder()
                    .novelId(Integer.valueOf(novelid))
                    .uid(novel_user_result.getData().getUid())
                    .build();
//            subscribe.setUid(novel_user_result.getData().getUid());
            subscribeService.save(subscribe);

        }
//        Map<Object, Object> map = new HashMap<>();
//        map.put("novelid", novelid);
//        map.put("email", email);
        if (subscribe == null) {
            result.setCode(404);
            result.setMsg("novelid:" + novelid + "不存在！");
        } else {
            result.setData(subscribe);
        }
        log.info("最终结果：{}",result);
//        result.setExtra(map);
        return result;
    }


    // 获取所有的订阅列表
    @GetMapping(path = "/subscriptions")
    public Results<Subscribe> getAllSubscriptions(){

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
