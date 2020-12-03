package org.xupeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xupeng
 * @date 2020/12/3 9:46
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
