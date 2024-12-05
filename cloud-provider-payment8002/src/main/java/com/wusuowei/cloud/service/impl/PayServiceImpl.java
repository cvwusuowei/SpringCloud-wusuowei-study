package com.wusuowei.cloud.service.impl;

import com.wusuowei.cloud.entities.Pay;
import com.wusuowei.cloud.mapper.PayMapper;
import com.wusuowei.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 15:04
 **/
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        
        return payMapper.insertSelective(pay);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
