package org.xupeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("org.xupeng.mapper")
public class NacosInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosInventoryApplication.class, args);
    }


}







