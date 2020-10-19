package org.xupeng.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xupeng.entities.CommonResult;
import org.xupeng.entities.PaymentEntity;

import javax.annotation.Resource;

/**
 * @author xupeng
 * @date 2020/10/19 11:22
 * @Description
 */

@RestController
@Slf4j
public class OrderController {


    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<PaymentEntity> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id,CommonResult.class, id);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<PaymentEntity> create(PaymentEntity payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

}
