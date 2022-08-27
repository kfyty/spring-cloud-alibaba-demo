package com.kfyty.demo.cloud.product.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kfyty.demo.cloud.product.mapper.ProductMapper;
import com.kfyty.demo.cloud.product.service.ProductService;
import com.kfyty.demo.cloud.product.service.model.ProductDO;
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
    private ProductMapper productMapper;

    @Override
    @Transactional
    @SentinelResource("updateProduct")
    public void updateProduct(Long productId) {
        ProductDO productDO = this.productMapper.findByPk(productId);
        productDO.setStock(productDO.getStock() - 1);
        this.productMapper.update(productDO);
    }
}
