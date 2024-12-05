package com.wusuowei.cloud.service;

import com.wusuowei.cloud.entities.Pay;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 15:01
 **/

public interface PayService {
    int add(Pay pay);
    int update(Pay pay);
    int delete(Integer id);

    Pay getById(Integer id);

    List<Pay> getAll();

}
