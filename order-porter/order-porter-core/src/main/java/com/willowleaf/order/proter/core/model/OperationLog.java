package com.willowleaf.order.proter.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 拉取操作的信息。
 *
 * @author dengb
 */
@Data
@NoArgsConstructor
@Entity
public class OperationLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 操作时间，也是上次拉取订单数据的截止时间。
     */
    @Column(nullable = false)
    private LocalDateTime operationTime;

    @Enumerated
    private Platform platform;

    public OperationLog(LocalDateTime operationTime, Platform platform) {
        this.operationTime = operationTime;
        this.platform = platform;
    }
}
