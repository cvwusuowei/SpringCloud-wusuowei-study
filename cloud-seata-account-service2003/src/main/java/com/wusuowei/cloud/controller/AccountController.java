package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.entities.Account;
import com.wusuowei.cloud.mapper.AccountMapper;
import com.wusuowei.cloud.service.AccountService;
import com.wusuowei.cloud.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-12-05 17:20
 **/
@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping("/account/decrease")
    Result<String> decrease(@RequestParam("userId")Long userId,@RequestParam("money")Long money){
        accountService.decrease(userId,money);
        return Result.success("扣减余额成功");
    }
}
