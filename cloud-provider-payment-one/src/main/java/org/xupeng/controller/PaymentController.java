package org.xupeng.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.xupeng.entities.CommonResult;
import org.xupeng.entities.PaymentEntity;
import org.xupeng.service.IPaymentService;

import javax.websocket.server.PathParam;

/**
 * @author xupeng
 * @date 2020/10/18 23:38
 * @Description
 */

@RestController
@Slf4j
@RequestMapping("/payment")
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/create")
    public CommonResult create(PaymentEntity paymentEntity) {
        int i = paymentService.create(paymentEntity);
        if (i > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort);
        }
        return new CommonResult(444, "插入数据失败");
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        PaymentEntity payment = paymentService.getPaymentById(id);
        if (payment !=  null) {
            return new CommonResult(200, "OK"+ serverPort,payment);
        }
        return new CommonResult(444, "NO",null);
    }

    @GetMapping("/sendMess")
    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                  @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String sendMess(@RequestParam("msg") String msg) throws InterruptedException {
//        double b = 5/0;
        Thread.sleep(5000);
        return "远程调用成功，message=" +msg;
    }

    public String fallback(String msg){
        return "fallback，应急处理: port :" + serverPort;
    }

    public Object globalFallback(){
        return "Global fallback exception";
    }

}
