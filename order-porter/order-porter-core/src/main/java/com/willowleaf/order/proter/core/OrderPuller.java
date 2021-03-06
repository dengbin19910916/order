package com.willowleaf.order.proter.core;

import com.willowleaf.order.commons.Order;
import com.willowleaf.order.proter.core.data.OperationRepository;
import com.willowleaf.order.proter.core.model.OperationLog;
import com.willowleaf.order.proter.core.model.Platform;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 定时拉取平台的订单报文。
 * 由子类实现如何拉取订单报文。
 *
 * @author dengb
 * @see OrderPuller#pull(TimeInterval) 拉取订单报文
 */
@Getter
public abstract class OrderPuller {

    @Autowired(required = false)
    protected TimeInterval timeInterval;
    @Autowired
    protected OperationRepository operationRepository;

    /**
     * 拉取订单数据并保存拉取日志。
     *
     * @return 订单信息列表
     */
    List<Order> pullAndSave() {
        List<Order> orders = pull(timeInterval);
        OperationLog operationLog = new OperationLog(timeInterval.getEndTime(getPlatform()), getPlatform());
        operationRepository.save(operationLog);
        return orders;
    }

    /**
     * 拉取平台的订单报文数据。
     *
     * @param timeInterval 定时器
     * @return 订单报文列表
     */
    protected abstract List<Order> pull(TimeInterval timeInterval);

    protected abstract Platform getPlatform();
}
