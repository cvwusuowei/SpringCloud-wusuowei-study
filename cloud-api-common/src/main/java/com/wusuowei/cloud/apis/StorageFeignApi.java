package com.wusuowei.cloud.apis;


import com.wusuowei.cloud.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {

    /**
     * 扣减库存
     * @param productId 商品ID
     * @param count 扣减数量
     * @return 结果集
     */
    @GetMapping("/storage/decrease")
    Result<Object> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
