package com.kfyty.demo.cloud.product.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kfyty.demo.cloud.product.mapper.UserMapper;
import com.kfyty.demo.cloud.product.service.ProductService;
import com.kfyty.demo.cloud.product.service.model.UserDO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/13 18:36
 * @email kfyty725@hotmail.com
 */
@DubboService
public class ProductServiceImpl implements ProductService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    @SentinelResource("updateProduct")
    public void updateProduct(Long userId, Integer productCnt) {
        UserDO userDO = new UserDO(userId, null, productCnt);
        this.userMapper.update(userDO);
    }
}
