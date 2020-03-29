package com.ly.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luoyong
 *  * @create 2020-03-29 4:34 下午
 *  * @last modify by [luoyong 2020-03-29 4:34 下午]
 * @Description: Payment
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;

    private String serial;
}
