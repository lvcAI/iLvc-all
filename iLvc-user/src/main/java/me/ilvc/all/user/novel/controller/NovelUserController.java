package me.ilvc.all.user.novel.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RestController
@RequestMapping("/iLvc-user/")
public class NovelUserController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = {"/users"})
    public Result getUserByEmail(@RequestParam String email) {

//        String email = request.getParameter("email");
        System.out.println("后台接收的数据："+email);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user = userService.getOne(wrapper.eq("email", email));
        System.out.println(email);
        Result<User> result = new Result<>();
        if (user == null) {
            result.setCode(400);
            result.setMsg("没有该用户！");
            // 创建一个用户
            User create_user = new User();
            create_user.setEmail(email);
            create_user.setUsername(email);
            create_user.setPassword("lvc123456");
//            暂时不处理
//            if (userService.save(user)) {
//                System.out.println("创建用户成功！");
//            }
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
