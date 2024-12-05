package com.wusuowei.cloud.apis;


import com.wusuowei.cloud.apis.PayFeignSentinelApi;
import com.wusuowei.cloud.entities.PayDTO;
import com.wusuowei.cloud.utils.Result;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelFallback implements PayFeignSentinelApi {
    @Override
    public Result<PayDTO> getPayByOrderNo(String orderNo) {
        return Result.fail("服务不可达");
    }
}
