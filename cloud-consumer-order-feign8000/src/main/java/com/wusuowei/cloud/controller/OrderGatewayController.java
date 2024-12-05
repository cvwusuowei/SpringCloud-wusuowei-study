package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.apis.PayFeignApi;
import com.wusuowei.cloud.entities.PayDTO;
import com.wusuowei.cloud.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign/gateway")
public class OrderGatewayController {
    @Resource
    private PayFeignApi payFeignApi;


    @GetMapping("/pay/get/{id}")
    public Result<PayDTO> getPayById(@PathVariable("id") Integer id) {
        return payFeignApi.getById4Gateway(id);
    }

    @GetMapping("/pay/getInfo")
    public Result<String> getInfo() {
        return payFeignApi.getInfo4Gateway();
    }

}
