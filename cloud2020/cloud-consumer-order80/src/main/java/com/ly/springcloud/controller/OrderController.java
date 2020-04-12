package com.ly.springcloud.controller;

import com.ly.springcloud.common.CommonResult;
import com.ly.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luoyong
 *  * @create 2020-03-29 11:15 下午
 *  * @last modify by [luoyong 2020-03-29 11:15 下午]
 * @Description: OrderController
 **/
@RestController
@Slf4j
public class OrderController {
    //不集群
//    private final static String PAYMENT_URL = "http://localhost:8001";
    //集群
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById?id=" + id, CommonResult.class);
    }

}
