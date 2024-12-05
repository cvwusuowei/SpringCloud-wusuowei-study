package com.wusuowei.cloud.service.impl;

import com.wusuowei.cloud.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-03 20:39
 **/
@Service
@Slf4j
public class FlowLimitServiceImpl implements FlowLimitService {
    @Override
    public void common() {
        log.info("into ... common ...");
    }
}
