package io.github.kalumcode.fly.mybaitsplus.starter.config;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * MybatisPlus 配置
 *
 * @Author: Kalum
 * @Date: 2021/6/6 9:25 上午
 * Version List
 * 版本        修改人        修改日期           修改描述
 * ------------------------------------------------------------
 * 1.0.0       Kalum       2021/6/6 9:25 上午   create
 * ------------------------------------------------------------
 */
@Slf4j
@Configuration
public class MybatisPlusConfig {

    @Resource
    private TenantLineInnerInterceptor tenantLineInnerInterceptor;

    /**
     * 配置插件
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor MybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 乐观锁
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 开启多租户
        mybatisPlusInterceptor.addInnerInterceptor(tenantLineInnerInterceptor);
        // 分页配置
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
        mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    /**
     * 配合多租户
     * 新多租户插件配置,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存万一出现问题
     *
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(Boolean.FALSE);
    }

    /**
     * 配置雪花算法在多实例机器上的workId
     * @return
     */
    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
        //从docker启动参数中获取应用实例WID环境变量
        Long workId = RandomUtil.randomLong(1, 999999999);
        String wid = System.getenv("WID");
        if (StrUtil.isNotEmpty(wid)) {
            workId = Long.parseLong(wid);
        }
        IdentifierGenerator identifierGenerator = new DefaultIdentifierGenerator(workId, 1L);
        return plusProperties -> plusProperties.getGlobalConfig().setIdentifierGenerator(identifierGenerator);
    }


}
