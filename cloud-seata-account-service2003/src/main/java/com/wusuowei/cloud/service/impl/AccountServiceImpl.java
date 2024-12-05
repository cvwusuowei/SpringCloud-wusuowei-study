package com.wusuowei.cloud.service.impl;

import com.wusuowei.cloud.mapper.AccountMapper;
import com.wusuowei.cloud.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-05 17:23
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------------->AccountService 开始扣减余额");
        accountMapper.decrease(userId, money);
        log.info("------------->AccountService 开始扣减余额");

        // 超时异常
//         timeout();
        // 抛出异常
//         int i = 10 / 0;
    }

    private void timeout() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
