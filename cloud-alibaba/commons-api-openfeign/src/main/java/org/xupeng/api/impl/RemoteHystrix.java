package org.xupeng.api.impl;

import org.springframework.stereotype.Component;
import org.xupeng.api.WarehouseClient;

/**
 * @author xupeng
 * @date 2020/12/24 14:49
 * @description
 */
@Component
public class RemoteHystrix implements WarehouseClient {
    @Override
    public Object update(Integer productId) {
        return null;
    }

    @Override
    public String hello() {
        return null;
    }
}
