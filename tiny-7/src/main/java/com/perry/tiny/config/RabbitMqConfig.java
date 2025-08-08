package com.perry.tiny.config;

import com.perry.tiny.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author perry
 * @description 消息队列配置
 * @date 2025/8/8 11:31
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 订单实际消费队列
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName());
    }

    /**
     * 订单延迟队列(死信队列)
     */
    @Bean
    public Queue orderTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName()) // 创建一个持久化的延迟队列
                .deadLetterExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange()) // 设置死信交换机，当消息过期后发送到该交换机
                .deadLetterRoutingKey(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey()) // 设置死信路由键，指定消息过期后的路由路径
                .build(); // 构建并返回配置好的队列对象
    }

    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    public DirectExchange orderDirect() {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟队列所绑定的死信交换机
     */
    @Bean
    public DirectExchange orderTtlDirect() {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单队列绑定到交换机
     */
    @Bean
    public Binding orderBinding(DirectExchange orderDirect, Queue orderQueue) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    /**
     * 订单延迟队列绑定到交换机
     */
    @Bean
    public Binding orderTtlBinding(DirectExchange orderTtlDirect, Queue orderTtlQueue) {
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }


}
