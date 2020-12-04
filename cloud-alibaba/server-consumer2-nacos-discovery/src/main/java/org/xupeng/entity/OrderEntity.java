package org.xupeng.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("t_order")
public class OrderEntity {

    @TableId
    private Integer id;
    private Integer productId;
    private Integer type;
    private Deprecated amount;
    private Integer paymentType;
    private Integer status;
    private Date createTime;
}
