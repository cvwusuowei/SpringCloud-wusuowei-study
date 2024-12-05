package com.wusuowei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: ${DATE} ${TIME}
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainOpenFeign8000 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign8000.class,args);
    }
}