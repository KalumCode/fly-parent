package io.github.kalumcode.fly.mybaitsplus.starter.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.boom.base.common.entity.BasicLoginInfo;
import com.boom.base.common.utils.ThreadLocalContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MybatisPlus 自动装载配置
 *
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER_ID = "updateUserId";
    public static final String DELETE_STATUS = "deleteStatus";
    public static final String VERSION = "version";

    /**
     * 新增语句自动填充字段
     *
     * @param metaObject:
     * @Author: lizhongbao
     * @Date: 2020/10/31 14:13
     * @return: void
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.strictInsertFill(metaObject, CREATE_TIME, Date.class, now);
        this.strictInsertFill(metaObject, UPDATE_TIME, Date.class, now);
        Long userId = 0L;
        BasicLoginInfo basicLoginInfo = ThreadLocalContext.get();
        if (null != basicLoginInfo && null != basicLoginInfo.getSysUserId()) {
            userId =basicLoginInfo.getSysUserId();
        }
        this.strictInsertFill(metaObject, UPDATE_USER_ID, Long.class, userId);
        this.strictInsertFill(metaObject, DELETE_STATUS, Integer.class, 0);
        this.strictInsertFill(metaObject, VERSION, Integer.class, 1);
    }

    /**
     * 修改语句自动填充字段
     *
     * @param metaObject:
     * @Author: lizhongbao
     * @Date: 2020/10/31 14:13
     * @return: void
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        this.setFieldValByName(UPDATE_TIME, now, metaObject);
//        this.strictUpdateFill(metaObject, UPDATE_TIME, Date.class, now);
//        this.strictUpdateFill(metaObject, UPDATE_USER_ID, Long.class, userId);
        // TODO 后面改为实际值
        Long userId = 0L;
        BasicLoginInfo basicLoginInfo = ThreadLocalContext.get();
        if (null != basicLoginInfo && null != basicLoginInfo.getSysUserId()) {
            userId =basicLoginInfo.getSysUserId();
        }
        this.setFieldValByName(UPDATE_USER_ID, userId, metaObject);
    }
}