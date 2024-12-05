package com.wusuowei.cloud;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 14:51
 **/
@SpringBootApplication
@MapperScan("com.wusuowei.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope
public class Main8001 {

    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
    

}
