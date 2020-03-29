package com.ly.springcloud.dao;

import com.ly.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:53 下午
 *  * @last modify by [luoyong 2020-03-29 4:53 下午]
 * @Description: PaymentDAO
 **/
@Mapper
public interface PaymentDAO {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
