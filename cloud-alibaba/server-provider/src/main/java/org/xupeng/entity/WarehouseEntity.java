package org.xupeng.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName("t_warehouse_product")
public class WarehouseEntity {

    @TableId
    private Integer wpId;
    private Integer productId;
    private Integer currentCnt;
    private Date modifiedTime;
}
