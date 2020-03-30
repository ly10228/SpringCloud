package com.ly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author luoyong
 *  * @create 2020-03-30 10:32 下午
 *  * @last modify by [luoyong 2020-03-30 10:32 下午]
 * @Description: EurekaApplication7001
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7001 {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
