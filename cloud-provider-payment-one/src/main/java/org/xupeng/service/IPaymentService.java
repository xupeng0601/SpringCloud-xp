package org.xupeng.service;


import org.xupeng.entities.PaymentEntity;


public interface IPaymentService {

    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentById(Long id);
}
