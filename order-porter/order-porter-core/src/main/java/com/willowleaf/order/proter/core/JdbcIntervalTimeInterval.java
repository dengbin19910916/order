package com.willowleaf.order.proter.core;

import com.willowleaf.order.proter.core.data.OperationRepository;
import com.willowleaf.order.proter.core.model.OperationLog;
import com.willowleaf.order.proter.core.model.Platform;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 基于数据库实现的定时器。
 *
 * @author dengb
 */
public class JdbcIntervalTimeInterval implements TimeInterval {

    private final OperationRepository operationRepository;
    private final JobProperties jobProperties;

    JdbcIntervalTimeInterval(OperationRepository operationRepository,
                             JobProperties jobProperties) {
        this.operationRepository = operationRepository;
        this.jobProperties = jobProperties;
    }

    @Override
    public LocalDateTime getStartTime(Platform platform) {
        Optional<OperationLog> lastOperation = operationRepository.findLastOperateTime(platform);
        return lastOperation.isPresent() ? lastOperation.get().getOperationTime() :
                jobProperties.getStartTime() != null ? jobProperties.getStartTime() : LocalDateTime.now();
    }

    @Override
    public LocalDateTime getEndTime(Platform platform) {
        return getStartTime(platform).plusSeconds(jobProperties.getTimeInterval());
    }
}
