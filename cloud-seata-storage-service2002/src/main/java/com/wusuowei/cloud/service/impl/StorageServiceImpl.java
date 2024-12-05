package com.wusuowei.cloud.service.impl;

import com.wusuowei.cloud.mapper.StorageMapper;
import com.wusuowei.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-05 18:04
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->StorageService 开始扣减库存");
        storageMapper.decrease(productId, count);
        log.info("------------->StorageService 扣减库存结束");
    }
}
