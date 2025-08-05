package com.perry.tiny.service;

import com.perry.tiny.domain.AdminUserDetails;

/**
 * @author perry
 * @description 后台用于管理service
 * @date 2025/8/4 19:23
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户信息
     */
    AdminUserDetails getAdminByUsername(String username);

    /**
     * 用户名密码登录
     */
    String login(String username, String password);
}
