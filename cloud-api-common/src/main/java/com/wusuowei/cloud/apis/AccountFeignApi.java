package com.wusuowei.cloud.apis;


import com.wusuowei.cloud.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {

    /**
     * 余额扣减
     * @param userId 用户id
     * @param money 扣了多少钱
     * @return 结果集
     */
    @GetMapping("/account/decrease")
    Result<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
