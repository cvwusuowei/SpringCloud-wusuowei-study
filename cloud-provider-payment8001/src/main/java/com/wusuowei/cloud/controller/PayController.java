package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.entities.Pay;
import com.wusuowei.cloud.entities.PayDTO;
import com.wusuowei.cloud.utils.*;
import com.wusuowei.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 15:10
 **/

@RestController
@Slf4j
@Tag(name="支付微服务模块",description = "支付CURD")
@RequestMapping("/pay")
public class PayController {
    @Resource
    private PayService payService;
    @Value("${server.port}")
    private Integer port;
    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水, 参数是JSON字符串")
    public Result<Integer> addPay(@RequestBody PayDTO payDTO) {
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(payDTO, pay);
            return Result.success(payService.add(pay));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水, 参数是Id")
    public Result<Integer> deletePay(@PathVariable("id") Integer id) {
        try {
            return Result.success(payService.delete(id));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PutMapping("/update")
    @Operation(summary = "更新", description = "更新支付流水, 参数是JSON字符串, 根据Id更新")
    public Result<Integer> updatePay(@RequestBody PayDTO payDTO) {
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(payDTO, pay);
            return Result.success(payService.update(pay));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单个", description = "查询支付流水, 参数是Id")
    public Result<PayDTO> getById(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(payService.getById(id), payDTO);
        return Result.success(payDTO);
    }

    @GetMapping("/getAll")
    @Operation(summary = "查询所有", description = "查询所有支付流水")
    public Result<List<PayDTO>> getAll() {
        try {
            List<Pay> pays = payService.getAll();
            List<PayDTO> payDTOs = BeanCopyUtil.copyListProperties(pays, PayDTO::new);
            return Result.success(payDTOs);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }
    @GetMapping("/getInfo")
    public Result<String> getInfo(@Value("${wusuowei.info}") String info) {
//        try {
//            TimeUnit.SECONDS.sleep(62);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return Result.success("port: " + port + "\t Info: " + info);
    }
}
