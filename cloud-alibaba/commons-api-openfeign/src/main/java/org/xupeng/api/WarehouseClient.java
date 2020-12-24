package org.xupeng.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.xupeng.api.impl.RemoteHystrix;

/**
 * 通过@FeginClient注解指定被调用方的服务名,就是在Nacos-server服务列表中的服务名
 * 通过fallback属性指定RemoteHystrix类，来进行远程调用的熔断和降级处理。
 */
@Component
@FeignClient(value = "SERVER-PROVIDER",fallback = RemoteHystrix.class)
public interface WarehouseClient {

    @PostMapping("/warehouse/update/{id}")
    Object update(@PathVariable("id") Integer productId);

    @GetMapping("/warehouse/hello")
    String hello();
}
