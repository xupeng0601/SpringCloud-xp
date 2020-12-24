package org.xupeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xupeng.api.WarehouseClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启服务注册发现功能
@EnableFeignClients    //表明该服务使用Openfeign
@MapperScan("org.xupeng.mapper")
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private RestTemplate restTemplate;




    /**
     * 注入RestTemplate调用server-provider服务;
     * LoadBalanced注解表示如果被调用的服务有多个节点，则默认采用轮询调用，实现负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String test() {
        //url拼写规则:  传输协议://服务名/访问路径
        return restTemplate.getForObject("http://SERVER-PROVIDER/hello",String.class);
    }

}
