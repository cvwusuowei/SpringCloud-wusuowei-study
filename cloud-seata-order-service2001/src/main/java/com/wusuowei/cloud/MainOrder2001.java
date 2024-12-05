package com.wusuowei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: ${DATE} ${TIME}
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.wusuowei.cloud.mapper")
public class MainOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder2001.class,args);
    }
}