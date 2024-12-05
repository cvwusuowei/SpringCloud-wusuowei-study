package com.wusuowei.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-03 20:38
 **/
public interface FlowLimitService {
    @SentinelResource("common")
    public void common();
}
