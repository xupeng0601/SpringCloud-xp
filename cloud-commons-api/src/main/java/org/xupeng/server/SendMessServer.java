package org.xupeng.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.xupeng.server.impl.SendMessImpl;

/**
 * @author xupeng
 * @date 2020/12/8 13:49
 * @description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE" ,fallback = SendMessImpl.class)
public interface SendMessServer {

    @GetMapping("/payment/sendMess")
    public String sendMess(@RequestParam("msg") String msg);
}
