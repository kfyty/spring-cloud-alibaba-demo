package com.kfyty.demo.cloud.consumer.service;

import com.kfyty.demo.cloud.consumer.mapper.UserMapper;
import com.kfyty.demo.cloud.product.service.ProductService;
import com.kfyty.demo.cloud.consumer.model.UserDO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/15 21:08
 * @email kfyty725@hotmail.com
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @DubboReference(check = false)
    private ProductService productService;

    @Transactional
    public void update(String name, Long productId) {
        UserDO userDO = new UserDO(null, name);
        this.userMapper.insert(userDO);
        this.productService.updateProduct(productId);
        if (name.equals("error")) {
            throw new RuntimeException("dev test");
        }
    }
}
