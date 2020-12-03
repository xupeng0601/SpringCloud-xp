package org.xupeng.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.xupeng.VO.ResultVO;
import org.xupeng.entity.WarehouseEntity;
import org.xupeng.mapper.IWarehouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RestController("/warehouse")
@Slf4j
public class WarehouseController {

    @Autowired
    private IWarehouseMapper warehouseMapper;

    @PostMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer productId){
        LambdaQueryWrapper<WarehouseEntity> lqy =  new QueryWrapper().lambda();
        lqy.eq(productId != null, WarehouseEntity::getProductId, productId);
        WarehouseEntity warehouse = warehouseMapper.selectOne(lqy);
        Integer count = warehouse.getCurrentCnt();
        log.info("目前的库存是: {}",count);
        warehouse.setCurrentCnt(--count);
        warehouseMapper.updateById(warehouse);
        return ResultVO.success();
    }

    @GetMapping("/helloNacos")
    public Object helloNacos(){
        return ResultVO.success();
    }
}
