package org.xupeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xupeng.dao.IPaymentDao;
import org.xupeng.entities.PaymentEntity;
import org.xupeng.service.IPaymentService;

/**
 * @author xupeng
 * @date 2020/10/18 23:35
 * @Description
 */
@Service
public class PaymentServiceImpl implements IPaymentService  {


    @Autowired
    private IPaymentDao paymentDao;

    @Override
    public int create(PaymentEntity paymentEntity) {
        return paymentDao.create(paymentEntity);
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
