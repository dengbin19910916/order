package com.willowleaf.order.commons;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 标准订单。
 *
 * @author dengb
 */
@Data
public class Order implements Serializable {

    private String id;

    private List<Goods> goods;
}
