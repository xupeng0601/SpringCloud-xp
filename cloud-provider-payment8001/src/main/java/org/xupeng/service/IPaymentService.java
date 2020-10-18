package org.xupeng.service;


import org.springframework.stereotype.Service;
import org.xupeng.entities.PaymentEntity;


public interface IPaymentService {

    public int create(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentById(Long id);
}
