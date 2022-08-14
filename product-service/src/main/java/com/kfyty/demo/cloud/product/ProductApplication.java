package com.kfyty.demo.cloud.product;

import com.alibaba.cloud.dubbo.service.DubboMetadataService;
import com.kfyty.demo.cloud.product.service.ProductService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/13 16:39
 * @email kfyty725@hotmail.com
 */
@EnableDubbo
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication implements CommandLineRunner {
    @Autowired
    private DubboMetadataService dubboMetadataService;

    @Autowired
    private ProductService productService;

    @GetMapping("product/test")
    public String test(String name) {
        return this.productService.test(name);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
