package com.perry.tiny.service.impl;

import com.perry.tiny.common.api.CommonResult;
import com.perry.tiny.component.CancelOrderSender;
import com.perry.tiny.dto.OrderParam;
import com.perry.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author perry
 * @description
 * @date 2025/8/8 16:00
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    public static final Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // todo 执行一系列下单操作
        LOGGER.info("生成订单");
        // 下单完成后会开启一个延迟消息，用于当用户没有付款时取消订单，订单超时取消需要使用
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        // todo 执行一系列取消订单的操作
        LOGGER.info("取消订单");
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60s，则为90s后发送取消订单消息
        long delayTimes = 60 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
