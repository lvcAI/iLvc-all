package me.ilvc.all.user.blog.mapper;

import me.ilvc.all.user.blog.service.impl.TUserServiceImpl;
import me.ilvc.all.user.club.mapper.ClubUserMapper;
import me.ilvc.all.user.club.service.impl.ClubUserServiceImpl;
import me.ilvc.all.user.novel.service.impl.NovelUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lvc
 * @create 2019/11/12 17:14
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class TUserTest {


    @Autowired
    private NovelUserServiceImpl novelUserService;

    @Autowired
    private ClubUserServiceImpl clubUserService;

    @Autowired
    private TUserServiceImpl tUserService;


    @Test
    public void test() {

        System.out.println(tUserService.getById(1));
        System.out.println(clubUserService.getById(10000));
        System.out.println(novelUserService.getById(1));



    }
}
