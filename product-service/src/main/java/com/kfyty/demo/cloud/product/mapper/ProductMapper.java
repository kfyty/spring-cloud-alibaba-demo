package com.kfyty.demo.cloud.product.mapper;

import com.kfyty.demo.cloud.product.service.model.ProductDO;
import com.kfyty.mybatis.auto.mapper.BaseMapper;
import com.kfyty.mybatis.auto.mapper.annotation.AutoMapper;
import com.kfyty.mybatis.auto.mapper.annotation.SelectKey;
import org.apache.ibatis.annotations.Mapper;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/15 21:16
 * @email kfyty725@hotmail.com
 */
@Mapper
@SelectKey
@AutoMapper(suffix = "DO")
public interface ProductMapper extends BaseMapper<Long, ProductDO> {

}
