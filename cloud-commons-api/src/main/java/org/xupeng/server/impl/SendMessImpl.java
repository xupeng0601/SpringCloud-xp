package org.xupeng.server.impl;

import org.springframework.stereotype.Component;
import org.xupeng.server.SendMessServer;

/**
 * @author xupeng
 * @date 2020/12/8 14:04
 * @description
 */

@Component
public class SendMessImpl implements SendMessServer {
    @Override
    public String sendMess(String message) {
        return "服务故障，执行降级处理";
    }
}
