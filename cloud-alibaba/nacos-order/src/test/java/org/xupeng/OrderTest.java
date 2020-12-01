package org.xupeng;

import org.xupeng.mapper.IOrderMapper;
import org.xupeng.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderTest {


    @Autowired
    private IOrderMapper orderMapper;


    @Test
    public void selectAll(){
        List<OrderEntity> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

}
