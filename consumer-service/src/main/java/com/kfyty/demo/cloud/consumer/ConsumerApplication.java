package com.kfyty.demo.cloud.consumer;

import com.kfyty.demo.cloud.consumer.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
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
    private ConsumerApplication __this;

    @Autowired
    private UserService userService;

    @GetMapping("consumer/user/save")
    public String saveUser(String name, Long id) {
        this.__this.update(name, id);
        return "ok";
    }

    @GlobalTransactional
    public void update(String name, Long id) {
        this.userService.update(name, id);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
