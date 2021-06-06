package io.github.kalumcode.fly.core.starter.log;

import lombok.Data;

/**
 * 日志打点公共字段
 *
 * @Author: Kalum
 * @Date: 2021/6/6 1:00 下午
 * Version List
 * 版本        修改人        修改日期           修改描述
 * ------------------------------------------------------------
 * 1.0.0       Kalum       2021/6/6 1:00 下午   create
 * ------------------------------------------------------------
 */
@Data
public class TraceCommonFieldDTO {

    /**
     * * 用户uid
     */
    private Long memberId;
}
