package io.github.kalumcode.fly.mybaitsplus.starter.config;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import io.github.kalumcode.fly.core.starter.utils.BaseAssert;
import lombok.AllArgsConstructor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多租户配置中心
 */
@Configuration
@AutoConfigureBefore(MybatisPlusConfig.class)
@EnableConfigurationProperties(TenantProperties.class)
@AllArgsConstructor
public class TenantConfiguration {

    private TenantProperties tenantProperties;

    /**
     * 新多租户插件配置,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存万一出现问题
     *
     * @return
     */
    @Bean
    public TenantLineInnerInterceptor tenantLineInnerInterceptor() {
        return new TenantLineInnerInterceptor(new TenantLineHandler() {
            /**
             * 获取租户ID
             * @return
             */
            @Override
            public Expression getTenantId() {
                Integer tenantId = ThreadLocalContext.get().getTenantId();
                BaseAssert.assertNotNull(tenantId, "租户ID不能为空");
                return new LongValue(tenantId);
            }

            /**
             * 获取多租户的字段名
             * @return String
             */
            @Override
            public String getTenantIdColumn() {
                return tenantProperties.getTenantId();
            }

            /**
             * 过滤不需要根据租户隔离的表
             * 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
             * @param tableName 表名
             */
            @Override
            public boolean ignoreTable(String tableName) {
                List<String> ignoreTableList = null;
                if (StrUtil.isBlank(tenantProperties.getIgnoreTables())) {
                    ignoreTableList = new ArrayList<>(1);
                } else {
                    String[] split = tenantProperties.getIgnoreTables().split(",");
                    ignoreTableList = Arrays.asList(split);
                }
                return ignoreTableList.stream().anyMatch(
                        (t) -> t.equalsIgnoreCase(tableName)
                );
            }
        });
    }
}