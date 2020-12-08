package org.xupeng.controller;

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
    public String sendMess(@RequestParam("msg") String msg){
        return "远程调用成功，message=" +msg;
    }

}
