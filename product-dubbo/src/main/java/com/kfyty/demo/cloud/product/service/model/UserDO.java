package com.kfyty.demo.cloud.product.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2022/8/15 21:16
 * @email kfyty725@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private Long id;
    private String username;
    private Integer productCnt;
}
