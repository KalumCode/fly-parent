package com.ggread.core.starter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误异常规范
 * @author: create by duanxiaoyong
 * @date: 2020/12/19
 **/
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 请求端参数异常
     */
    NO_VALID_PARAM(1000, "请求端参数异常"),

    /**
     * token过期
     */
    TOKEN_EXPIRE(2000, "token过期"),

    /**
     * 认证失败
     */
    TOKEN_AUTH_ERROR(2001, "token认证失败"),

    /**
     * token无效或已过期
     */
    TOKEN_INVALID(2003, "token无效"),

    /**
     * 访问未授权
     */
    USER_ACCESS_UNAUTHORIZED(2004, "访问未授权"),

    /**
     * 客户端不存在
     */
    NO_SUCH_CLIENT(2005, "客户端不存在"),

    /**
     * 用户账户被冻结
     */
    USER_ACCOUNT_LOCKED(2006, "用户账户被冻结"),

    /**
     * 业务条件不满足提醒
     */
    TIP_MESSAGE(3000, "业务条件不满足提醒"),

    /**
     * 接口不存在
     */
    NO_HANDLER(4000, "接口不存在"),

    /**
     * 服务器内部错误
     */
    SERVER_ERROR(5000, "服务器内部错误"),

    /**
     * 请求失败
     */
    FAIL(5001, "请求失败"),

    /**
     * 业务异常
     */
    TRANSACTION_ERROR(5002, "业务异常"),

    /**
     * 接口超时
     */
    CONNECT_TIMEOUT(5003, "接口超时"),

    /**
     * 数据异常
     */
    DATA_ERROR(6000, "数据异常"),

    /**
     * Redis异常
     **/
    REDIS_ERROR(7000, "Redis异常"),


    /**
     * 微信服务器服务异常
     */
    WX_ERROR(8000, "微信服务异常");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;

}
