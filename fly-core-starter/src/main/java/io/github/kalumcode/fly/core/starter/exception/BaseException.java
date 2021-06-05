package io.github.kalumcode.fly.core.starter.exception;

import cn.hutool.core.util.StrUtil;
import io.github.kalumcode.fly.core.starter.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author: create by duanxiaoyong
 * @date: 2020/12/19
 **/
public class BaseException extends RuntimeException implements Serializable {

    private Integer code;

    public BaseException() {
    }

    public BaseException(String msg, Object... arguments) {
        super(StrUtil.format(msg, arguments));
        this.code = ResponseEnum.SERVER_ERROR.getCode();
    }

    public BaseException(ResponseEnum baseEnumType) {
        super(baseEnumType.getMsg());
        this.code = baseEnumType.getCode();
    }

    public BaseException(ResponseEnum baseEnumType, String msg, Object... arguments) {
        super(StrUtil.format(msg, arguments));
        this.code = baseEnumType.getCode();
    }

    public BaseException(Integer code, String msg, Object... arguments) {
        super(StrUtil.format(msg, arguments));
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
