package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.service.StorageService;
import com.wusuowei.cloud.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-05 17:58
 **/
@Slf4j
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    Result<String> decrease(@RequestParam("productId")Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return Result.success("扣库存成功");
    }
}
