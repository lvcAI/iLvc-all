package me.ilvc.all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Lvc
 * @create 2019/11/11 21:14
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerRegistryCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRegistryCenterApplication.class, args);
    }
}
