package org.xupeng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.xupeng.VO.ResultVO;
import org.xupeng.api.WarehouseClient;
import org.xupeng.entity.OrderEntity;
import org.xupeng.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Value("${server.port}")
    private String port;

    @Autowired
    private WarehouseClient warehouseClient;


    @GetMapping("hello")
    public String hello(){
        return warehouseClient.hello();
    }

    @PostMapping("/payment/{id}")
    public Object payment(@PathVariable("id") Integer orderId) {
        OrderEntity order = orderMapper.selectById(orderId);
        if (order != null) {
            //2表示已付款
            order.setStatus(2);
            orderMapper.updateById(order);
            //付款成功需要发货，
            warehouseClient.update(order.getProductId());
            return ResultVO.success();
        }
        return ResultVO.failure(410,"没有找到对应的订单  port=" +port) ;
    }
}
