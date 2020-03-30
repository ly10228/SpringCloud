package com.ly.springcloud.common.enums;

import lombok.Getter;

/**
 * @author luoyong
 *  * @create 2020-03-29 5:18 下午
 *  * @last modify by [luoyong 2020-03-29 5:18 下午]
 * @Description: ResultEnum
 **/
@Getter
public enum ResultEnum {
    /**
     * 1:正常
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 0：禁用
     */
    FAil(500, "Fail");

    /**
     * 枚举值
     */
    private Integer code;
    /**
     * 描述
     */
    private String desc;

    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
