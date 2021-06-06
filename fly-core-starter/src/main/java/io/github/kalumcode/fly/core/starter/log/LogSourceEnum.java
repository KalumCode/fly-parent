package io.github.kalumcode.fly.core.starter.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Author: Kalum
 * @Date: 2021/6/6 8:59 上午
 * Version List
 * 版本        修改人        修改日期           修改描述
 * ------------------------------------------------------------
 * 1.0.0       Kalum       2021/6/6 8:59 上午   create
 * ------------------------------------------------------------
 */
@Getter
@AllArgsConstructor
public enum LogSourceEnum {

    /**
     * APP
     */
    APP("APP", "APP"),

    /**
     * PC
     */
    PC("PC", "PC");

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;

    public Optional<LogSourceEnum> getEnumByCode(Integer value) {
        return Arrays.stream(LogSourceEnum.values()).filter(item -> item.getCode().equals(value)).findFirst();
    }

}
