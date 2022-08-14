package com.kfyty.demo.cloud.product.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kfyty.demo.cloud.product.service.ProductService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/13 18:36
 * @email kfyty725@hotmail.com
 */
@DubboService
public class ProductServiceImpl implements ProductService {

    @Override
    @SentinelResource("test")
    public String test(String name) {
        return "hello " + name;
    }
}
