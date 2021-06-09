package io.github.kalumcode.fly.mybaitsplus.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 租户配置参数
 */
@Data
@ConfigurationProperties(prefix = "tenant")
public class TenantProperties {

    /**
     * 排除租户的表名
     */
    private String ignoreTables;

    /**
     * 多租户字段名称
     */
    private String tenantId;

}