package com.wusuowei.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-28 20:34
 **/
@Configuration
public class FeignConfig {
    // 重试机制
    @Bean
    public Retryer myRetryer() {
        return new Retryer.Default();
        // 初次间隔 最大间隔 最大请求次数(1+2) = 3
//        return new Retryer.Default(100, 1, 3);
    }

    // 日志记录级别
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
