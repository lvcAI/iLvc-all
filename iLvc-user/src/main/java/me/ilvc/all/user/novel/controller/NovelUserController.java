package me.ilvc.all.user.novel.controller;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.User;
import me.ilvc.all.user.novel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class NovelUserController {

    @Autowired
    private IUserService userService;



    @GetMapping(path = {"/users"})
    public Result<User> getUserByEmail(@RequestParam String email) {
    log.info("email:{}",email);
//        String email = request.getParameter("email");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user = userService.getOne(wrapper.eq("email", email));
        System.out.println(email);
        Result<User> result = new Result<>();
        if (user == null) {
            // 创建一个用户
            User create_user = new User();
            create_user.setEmail(email);
            create_user.setUsername(email);
            create_user.setPassword("lvc123456");
            // 暂时不处理
            if (userService.save(create_user)) {
                System.out.println("创建用户成功！");
                log.info("创建用户 {} 成功！",email);
                user = userService.getOne(wrapper.eq(email, email));
            }else {
                result.setCode(400);
                result.setMsg("创建用户失败！");
            }
        } else {
            result.setCode(200);
            result.setMsg("查找用户成功！");
            result.setData(user);
        }
        return result;
    }



    @PostMapping("/users/")
    public Result createUser() {
        Result<User> userResult = new Result<>();

        return userResult;
    }



}
