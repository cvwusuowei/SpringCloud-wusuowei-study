package com.wusuowei.cloud.controller;

import com.wusuowei.cloud.entities.PayDTO;
import com.wusuowei.cloud.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.StringJoiner;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 19:33
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("/pay/add")
    public Object addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, Result.class);
    }
    @DeleteMapping("/pay/del/{id}")
    public Object delOrder(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PAYMENT_URL + "/pay/del/" + id, HttpMethod.DELETE, null, Result.class).getBody();
    }

    @PutMapping("/pay/update")
    public Object delOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.exchange(PAYMENT_URL + "/pay/update/", HttpMethod.PUT, new HttpEntity<>(payDTO), Result.class).getBody();
    }
    @GetMapping("/pay/get/{id}")
    public Object getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, Result.class, id);
    }

    @GetMapping("/pay/getAll")
    public Object getPayListInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getAll", Result.class);
    }

    @GetMapping("/pay/getInfo")
    public Object getInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getInfo", Result.class);
    }

    @GetMapping("/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        System.out.println("=================");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(instance.getServiceId());
            joiner.add(instance.getHost());
            joiner.add(instance.getPort() + "");
            joiner.add(instance.getUri() + "");
            System.out.println(joiner);
        }
        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
    }
}
