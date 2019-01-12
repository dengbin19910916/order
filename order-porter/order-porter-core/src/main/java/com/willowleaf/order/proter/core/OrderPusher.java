package com.willowleaf.order.proter.core;

import com.willowleaf.order.commons.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.willowleaf.order.proter.core.JobAutoConfiguration.ORDER_QUEUE_NAME;

/**
 * 将标准订单推送至RabbitMQ。
 *
 * @author dengb
 */
@Component
public class OrderPusher {

    private final AmqpTemplate amqpTemplate;

    public OrderPusher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    void push(List<Order> orders) {
        if (orders.size() > 0) {
            amqpTemplate.convertAndSend(ORDER_QUEUE_NAME, orders);
        }
    }
}
