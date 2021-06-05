package io.github.kalumcode.fly.core.starter.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: create by duanxiaoyong
 * @date: 2021/1/10
 **/
@Data
@ApiModel(description = "租户参数")
public class BaseVO implements Serializable{
    /**
     * 租户id
     **/
    @ApiModelProperty(value = "租户id")
    private Integer tenantId;
}