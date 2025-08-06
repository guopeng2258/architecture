package com.perry.tiny.service;

import com.perry.tiny.domain.AdminUserDetails;
import com.perry.tiny.domain.UmsResource;

import java.util.List;

/**
 * @author perry
 * @description 用户管理Service
 * @date 2025/8/5 16:46
 */
public interface UmsAdminService {
    /**
     * 用户登录
     */
    String login(String username, String password);
    /**
     * 获取用户信息
     */
    AdminUserDetails getAdminByUsername(String username);
    /**
     * 获取用户权限列表
     */
    List<UmsResource> getResourceList();

}
