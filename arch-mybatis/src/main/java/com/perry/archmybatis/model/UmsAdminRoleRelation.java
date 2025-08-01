package com.perry.archmybatis.model;

import java.io.Serializable;

/**
 * 后台用户和角色关系表
 */
public class UmsAdminRoleRelation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 管理员ID
     */
    private Long adminId;
    
    /**
     * 角色ID
     */
    private Long roleId;
    
    // 无参构造函数
    public UmsAdminRoleRelation() {
    }
    
    // 全参构造函数
    public UmsAdminRoleRelation(Long id, Long adminId, Long roleId) {
        this.id = id;
        this.adminId = adminId;
        this.roleId = roleId;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAdminId() {
        return adminId;
    }
    
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    @Override
    public String toString() {
        return "UmsAdminRoleRelation{" +
               "id=" + id +
               ", adminId=" + adminId +
               ", roleId=" + roleId +
               '}';
    }
}