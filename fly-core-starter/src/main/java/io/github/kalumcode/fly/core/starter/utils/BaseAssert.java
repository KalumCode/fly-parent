package io.github.kalumcode.fly.core.starter.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;

import io.github.kalumcode.fly.core.starter.enums.ResponseEnum;
import io.github.kalumcode.fly.core.starter.exception.BaseException;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 断言处理类，用于抛出各种null或空异常
 *
 * @author: create by duanxiaoyong
 * @date: 2020/12/22
 **/
public class BaseAssert {

    public static void assertNotNull(Object obj, String message, Object... args) {
        if (Objects.isNull(obj)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertNotEmpty(String str, String message, Object... args) {
        if (StrUtil.isBlank(str)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertNotEmpty(Object[] arrays, String message, Object... args) {
        if (arrays == null || arrays.length == 0) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertNotEmpty(Collection<?> c, String message, Object... args) {
        if (CollectionUtils.isEmpty(c)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertNotEmpty(Map<?, ?> map, String message, Object... args) {
        if (MapUtil.isEmpty(map)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertIsEmpty(Collection<?> c, String message, Object... args) {
        if (!CollectionUtils.isEmpty(c)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertIsFalse(Boolean expression, String message, Object... args) {
        if (BooleanUtil.isTrue(expression)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertIsTrue(Boolean expression, String message, Object... args) {
        if (!BooleanUtil.isTrue(expression)) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

    public static void assertIsNull(Object obj, String message, Object... args) {
        if (obj != null) {
            throw new BaseException(ResponseEnum.TIP_MESSAGE, StrUtil.format(message, args));
        }
    }

}
