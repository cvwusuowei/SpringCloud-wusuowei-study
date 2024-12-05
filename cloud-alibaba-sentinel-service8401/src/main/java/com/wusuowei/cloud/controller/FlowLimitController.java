package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-03 20:36
 **/
@RestController
@Slf4j
public class FlowLimitController {
    @Resource
    private FlowLimitService flowLimitService;
    @GetMapping("/testA")
    public String testA(){
        return "into ...A ...";
    }
    @GetMapping("/testB")
    public String testB() {
        return "into ... B ...";
    }

    @GetMapping("/testC")
    public String testC(){
        flowLimitService.common();
        return "into ... C...";
    }
    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "into ... D ...";
    }
    @GetMapping("/testE")
    public String testE() {
        log.info("E: {}", System.currentTimeMillis());
        return "into ... E ...";
    }
    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("熔断测试, 慢调用比例");
        return "into ... F ...";
    }
    @GetMapping("/testG")
    public String testG() {
        throw new RuntimeException("模拟异常");
    }

}
