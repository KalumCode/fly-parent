package io.github.kalumcode.fly.core.starter.log;

import lombok.Data;

/**
 * @Author: Kalum
 * @Date: 2021/6/6 9:27 上午
 * Version List
 * 版本        修改人        修改日期           修改描述
 * ------------------------------------------------------------
 * 1.0.0       Kalum       2021/6/6 9:27 上午   create
 * ------------------------------------------------------------
 */
@Data
public class TracePvDTO extends BaseTraceDTO{

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 统计数值
     */
    private Integer summary;
}
