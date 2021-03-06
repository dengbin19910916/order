package com.willowleaf.order.proter.jd;

import com.willowleaf.order.commons.Goods;
import com.willowleaf.order.commons.Order;
import com.willowleaf.order.proter.core.OrderPuller;
import com.willowleaf.order.proter.core.TimeInterval;
import com.willowleaf.order.proter.core.model.Platform;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class JdOrderPuller extends OrderPuller {

    @Override
    protected List<Order> pull(TimeInterval timeInterval) {
        System.out.println("拉取京东订单，开始时间：" + timeInterval.getStartTime(getPlatform()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + "，结束时间：" + timeInterval.getEndTime(getPlatform()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "。");
        Order order1 = new Order();
        order1.setId("JD_ORDER-1");
        Goods goods1 = new Goods();
        goods1.setId("JD_GOODS-1");
        order1.setGoods(Collections.singletonList(goods1));

        Order order2 = new Order();
        order2.setId("JD_ORDER-2");
        Goods goods2 = new Goods();
        goods2.setId("JD_GOODS-2");
        order2.setGoods(Collections.singletonList(goods2));

        return Arrays.asList(order1, order2);
    }

    @Override
    protected Platform getPlatform() {
        return Platform.JD;
    }
}
