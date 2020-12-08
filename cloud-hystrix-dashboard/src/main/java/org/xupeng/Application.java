package org.xupeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author xupeng
 * @date 2020/12/8 10:24
 * @description
 */
@EnableDiscoveryClient  //声明这是一个Eureka客户端
@EnableCircuitBreaker   //开启Hystrix的熔断
@EnableHystrix
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
