package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.apis.PayFeignApi;
import com.wusuowei.cloud.utils.Result;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-29 16:31
 **/
@RestController
@RequestMapping("/feign")
public class OrderCircuitController {
    @Resource
    private PayFeignApi payFeignApi;
    @GetMapping("/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "fallback4CircuitBreaker")
    public Result<String> getPayById4CircuitBreaker(@PathVariable("id")Integer id){
       return payFeignApi.myCircuit(id);
    }
    @GetMapping("/pay/semaphore/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "fallback4BulkheadThreadPool", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<Result<String>> getPayById4Bulkhead(@PathVariable("id") Integer id) {
        System.out.println(Thread.currentThread().getName() + " into ...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " over ...");
        return CompletableFuture.supplyAsync(() -> payFeignApi.mySemaphore(id));
    }

    @GetMapping("/pay/rateLimit/{id}")
    @RateLimiter(name = "cloud-payment-service", fallbackMethod = "fallback4RateLimit")
    public Result<String> getPayById4RateLimit(@PathVariable("id") Integer id) {
        return payFeignApi.mySemaphore(id);
    }

    public Result<String> fallback4CircuitBreaker(Throwable throwable) {
        return Result.success("系统繁忙, 请稍后重试...");
    }

    public Result<String> fallback4Bulkhead(Throwable throwable) {
        return Result.success("超出最大请求数量限制, 请稍后重试...");
    }

    public CompletableFuture<Result<String>> fallback4BulkheadThreadPool(Throwable throwable) {
        return CompletableFuture.supplyAsync(() -> Result.fail("超出最大请求数量限制, 请稍后重试..."));
    }

    public Result<String> fallback4RateLimit(Throwable throwable) {
        return Result.success("服务器限流, 请稍后重试...");
    }

}
