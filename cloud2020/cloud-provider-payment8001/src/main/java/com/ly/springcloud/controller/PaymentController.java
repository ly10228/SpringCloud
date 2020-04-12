package com.ly.springcloud.controller;

import com.ly.springcloud.common.CommonResult;
import com.ly.springcloud.common.enums.ResultEnum;
import com.ly.springcloud.entity.Payment;
import com.ly.springcloud.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:59 下午
 *  * @last modify by [luoyong 2020-03-29 4:59 下午]
 * @Description: PaymentController
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @PostMapping("save")
    @ApiOperation(value = "保存支付流水信息")
    CommonResult<Boolean> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i <= 0) {
            return new CommonResult(ResultEnum.FAil.getCode(), ResultEnum.FAil.getDesc(), true);
        }
        return new CommonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), true);
    }

    @GetMapping("getPaymentById")
    @ApiOperation(value = "获取支付信息")
    CommonResult<Payment> getPaymentById(@RequestParam Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommonResult(ResultEnum.FAil.getCode(), ResultEnum.FAil.getDesc(), null);
        }
        return new CommonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), payment);
    }


    /**
     * @return
     * @Description: 服务发现 获取服务信息
     * @author luoyong
     * @create 7:08 下午 2020/4/12
     * @last modify by [LuoYong 7:08 下午 2020/4/12 ]
     */
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
