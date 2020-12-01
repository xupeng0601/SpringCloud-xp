package org.xupeng.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @description:
 */
@Component
@FeignClient(value = "nacos-inventory")
public interface InventoryClient {

    @PostMapping("/warehouse/update/{id}")
    Object update(@PathVariable("id") Integer productId);
}
