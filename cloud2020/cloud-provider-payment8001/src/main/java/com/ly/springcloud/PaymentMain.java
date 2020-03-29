package com.ly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:22 下午
 *  * @last modify by [luoyong 2020-03-29 4:22 下午]
 * @Description: 主配置类
 **/
@ComponentScan({ "com.ly.springcloud"})
@SpringBootApplication
public class PaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
    }
}
