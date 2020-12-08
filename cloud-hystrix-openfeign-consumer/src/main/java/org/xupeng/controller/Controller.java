package org.xupeng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xupeng.server.SendMessServer;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * @author xupeng
 * @date 2020/12/8 13:43
 * @description
 */
@RestController
public class Controller {


    @Resource
    private SendMessServer sendMessServer;

    @GetMapping("/sendMess")
    public String sendMess(@RequestParam("msg") String msg){
        String result = sendMessServer.sendMess(msg);
        return result;
    }

}
