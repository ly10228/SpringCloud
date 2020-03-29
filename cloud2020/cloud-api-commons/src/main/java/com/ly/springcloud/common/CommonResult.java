package com.ly.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luoyong
 *  * @create 2020-03-29 5:01 下午
 *  * @last modify by [luoyong 2020-03-29 5:01 下午]
 * @Description: 请求处理统一返回结果
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
