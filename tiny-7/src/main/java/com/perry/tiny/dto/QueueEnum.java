package com.perry.tiny.dto;

import lombok.Getter;

/**
 * @author perry
 * @description 消息队列枚举类
 * @date 2025/8/8 11:28
 */
@Getter
public enum QueueEnum {
    // 订单消息通知队列
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    // 订单延迟消息通知队列
    QUEUE_TTL_ORDER_CANCEL("mall.order.ttl.direct", "mall.order.cancel.ttl", "mall.order.cancel.ttl");
    // 消息交换机
    private String exchange;
    // 队列名称
    private String name;
    // 路由键
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
