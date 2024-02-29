package com.vincent.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2023/12/7 10:30
 */
@Data
public class OrderVo {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 下单用户ID
     */
    private Long userId;
    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer userAge;
    /**
     * 性别
     */
    private Integer userGender;
}
