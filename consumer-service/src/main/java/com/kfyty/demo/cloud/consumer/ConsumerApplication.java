package com.kfyty.demo.cloud.consumer;

import com.kfyty.demo.cloud.product.service.ProductService;
import org.apache.dubbo.config.annotation.DubboReference;
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
    @DubboReference
    private ProductService productService;

    @GetMapping("consumer/test")
    public String test(String name) {
        return this.productService.test(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
