package com.wusuowei.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 14:58
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PayDTO implements Serializable {

    private Integer id;

    /**
     * 支付流水号
     */

    private String payNo;

    /**
     * 订单流水号
     */

    private String orderNo;

    /**
     * 用户账号ID
     */
    private Integer userId;
    /**
     * 交易金额
     */
    private BigDecimal amount;
}
