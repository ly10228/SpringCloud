package com.ly.springcloud.service;

import com.ly.springcloud.entity.Payment;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:56 下午
 *  * @last modify by [luoyong 2020-03-29 4:56 下午]
 * @Description: PaymentService
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
