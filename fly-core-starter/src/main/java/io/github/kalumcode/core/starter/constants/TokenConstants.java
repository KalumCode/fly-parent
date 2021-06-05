package com.ggread.core.starter.constants;

/**
 * Token相关的常量
 */
public interface TokenConstants {
    /**
     * 租户Id
     */
    String TENANT_ID = "Tenant-Id";

    /**
     * 小程序令牌自定义标识
     */
    String TOKEN_HEADER_MEMBER = "GG-Member-Token";

    /**
     * 运营后台令牌自定义标识
     */
    String TOKEN_HEADER_ADMIN = "GG-Admin-Token";

    /**
     * 返回新Token令牌自定义标识
     */
    String TOKEN_HEADER_NEW = "GG-New-Token";


    /**
     * 会员ID字段
     */
    String HEADER_MEMBER_ID = "Member-Id";

    /**
     * 会员名字段
     */
    String HEADER_MEMBER_NAME = "Member-Name";

    /**
     * 头像
     */
    String HEAD_AVATAR_URL = "Avatar-Url";


    /**
     * 系统用户ID字段
     */
    String HEADER_SYS_USER_ID = "Sys-User-Id";

    /**
     * 系统用户名字段
     */
    String HEADER_SYS_USER_NAME = "Sys-User-Name";
}
