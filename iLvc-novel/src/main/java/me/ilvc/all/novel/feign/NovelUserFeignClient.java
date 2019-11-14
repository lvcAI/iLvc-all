package me.ilvc.all.novel.feign;

import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 调用 iLvc-user 的服务
 *
 * @author Lvc
 * @create 2019/11/13 13:59
 */
@Component
@FeignClient("iLvc-user") // 指定访问模块
public interface NovelUserFeignClient {

    @GetMapping(path = {"/users"})
    Result<User> getUserByEmail(@RequestParam String email);

}
