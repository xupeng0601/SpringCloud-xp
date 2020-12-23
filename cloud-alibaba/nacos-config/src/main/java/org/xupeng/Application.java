package org.xupeng;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient   //服务注册与发现
@RestController          //对外访问接口
@RefreshScope            //可以使当前类下的配置支持动态更新
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 其中通过@Value注解，去读取key为nacos.info的配置的值，并通过/getInfo接口返回。
     */
    @Value("${nacos.info}")
    private String info;

    @RequestMapping("/getInfo")
    public String getValue() {
        return info;
    }
}
