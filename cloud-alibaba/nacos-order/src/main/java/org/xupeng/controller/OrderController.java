package org.xupeng.controller;

import org.xupeng.VO.ResultVO;
import org.xupeng.api.InventoryClient;
import org.xupeng.entity.OrderEntity;
import org.xupeng.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderMapper orderMapper;


    @Autowired
    private InventoryClient inventoryClient;


    @PostMapping("/payment/{id}")
    public Object payment(@PathVariable("id") Integer orderId) {
        OrderEntity order = orderMapper.selectById(orderId);
        if (order != null) {
            //2表示已付款
            order.setStatus(2);
            orderMapper.updateById(order);
            //付款成功需要发货，
            inventoryClient.update(order.getProductId());
            return ResultVO.success();
        }
        return ResultVO.failure(410,"没有找到对应的订单");
    }
}
