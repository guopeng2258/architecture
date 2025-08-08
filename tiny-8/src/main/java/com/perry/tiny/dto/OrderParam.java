package com.perry.tiny.dto;

import lombok.Data;

/**
 * @author perry
 * @description
 * @date 2025/8/8 15:42
 */
@Data
public class OrderParam {
    // 收货地址
    private Long memberReceiveAddressId;
    // 优惠券id
    private Long couponId;
    // 使用的积分数
    private Integer useIntegration;
    // 支付方式
    private Integer payType;

}
