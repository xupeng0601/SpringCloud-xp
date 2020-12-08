package org.xupeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xupeng
 * @date 2020/12/8 11:08
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启服务注册发现功能
@EnableFeignClients   //表示该服务使用OpenFeign服务
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
