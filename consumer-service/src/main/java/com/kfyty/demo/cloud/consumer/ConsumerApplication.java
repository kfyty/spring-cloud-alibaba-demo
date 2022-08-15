package com.kfyty.demo.cloud.consumer;

import com.kfyty.demo.cloud.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/13 19:03
 * @email kfyty725@hotmail.com
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
    @Autowired
    private UserService userService;

    @GetMapping("consumer/user/save")
    public String saveUser(String name, Integer cnt) {
        this.userService.update(name, cnt);
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
