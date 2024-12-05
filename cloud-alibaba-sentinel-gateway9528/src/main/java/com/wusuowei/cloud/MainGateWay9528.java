package com.wusuowei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: ${DATE} ${TIME}
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainGateWay9528 {
    public static void main(String[] args) {
        SpringApplication.run(MainGateWay9528.class,args);
    }
}