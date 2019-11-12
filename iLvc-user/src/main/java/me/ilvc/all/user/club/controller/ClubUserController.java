package me.ilvc.all.user.club.controller;


import me.ilvc.all.user.club.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/iLvc-user/user")
public class ClubUserController {

    @Autowired
    private IUserService userService;



}
