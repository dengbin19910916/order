package com.willowleaf.order.commons;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单商品。
 *
 * @author dengb
 */
@Data
public class Goods implements Serializable {

    private String id;
    /**
     * 商品名称。
     */
    private String name;
    /**
     * 商品价格。
     */
    private BigDecimal price;
    /**
     * 所属订单。
     */
    private Order order;
}
