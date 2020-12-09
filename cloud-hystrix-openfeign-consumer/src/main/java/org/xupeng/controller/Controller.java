package org.xupeng.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xupeng.server.SendMessServer;

import javax.annotation.Resource;

/**
 * @author xupeng
 * @date 2020/12/8 13:43
 * @description
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class Controller {


    @Value("${server.port}")
    private String port;

    @Resource
    private SendMessServer sendMessServer;

    @HystrixCommand( fallbackMethod = "fallback", commandProperties =
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000"))
    @GetMapping("/sendMess")
    public String sendMess(@RequestParam("msg") String msg) {
//        double b = 10 /0;
        String result = sendMessServer.sendMess(msg);
        return result;
    }

    @GetMapping("timeout")
    @HystrixCommand(  commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String timeout() throws InterruptedException {
        int a = 10/0;        log.info("线程等待");

        Thread.sleep(2000);
        return "等待结束，成功返回,端口: " + port;
    }

    public String fallback(String msg) {
        return "fallback handler : port : " + port;
    }


    public String globalFallback(){
        return "Global fallback exception";
    }




}
