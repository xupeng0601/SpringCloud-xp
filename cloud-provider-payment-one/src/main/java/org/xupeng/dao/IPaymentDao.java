package org.xupeng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.xupeng.entities.PaymentEntity;


/**
 * @author xupeng
 * @date 2020/10/18 23:19
 * @Description
 */
@Mapper
public interface IPaymentDao {


    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentById(@Param("id") Long id);







}
