package org.xupeng.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xupeng
 * @date 2020/10/19 11:20
 * @Description
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
