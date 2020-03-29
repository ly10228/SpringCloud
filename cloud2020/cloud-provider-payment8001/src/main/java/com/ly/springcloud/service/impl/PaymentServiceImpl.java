package com.ly.springcloud.service.impl;

import com.ly.springcloud.dao.PaymentDAO;
import com.ly.springcloud.entity.Payment;
import com.ly.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:57 下午
 *  * @last modify by [luoyong 2020-03-29 4:57 下午]
 * @Description: PaymentServiceImpl
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
