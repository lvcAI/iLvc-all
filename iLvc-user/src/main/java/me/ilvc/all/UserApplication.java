package me.ilvc.all;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lvc
 * @create 2019/11/12 15:48
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = {"me.ilvc.all.user.blog.mapper","me.ilvc.all.user.club.mapper","me.ilvc.all.user.novel.mapper"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
