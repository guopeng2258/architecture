package com.perry.archmybatis.model;

import java.io.Serializable;

/**
 * 后台角色资源关系表
 */
public class UmsRoleResourceRelation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 角色ID
     */
    private Long roleId;
    
    /**
     * 资源ID
     */
    private Long resourceId;
    
    // 无参构造函数
    public UmsRoleResourceRelation() {
    }
    
    // 全参构造函数
    public UmsRoleResourceRelation(Long id, Long roleId, Long resourceId) {
        this.id = id;
        this.roleId = roleId;
        this.resourceId = resourceId;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public Long getResourceId() {
        return resourceId;
    }
    
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    
    @Override
    public String toString() {
        return "UmsRoleResourceRelation{" +
               "id=" + id +
               ", roleId=" + roleId +
               ", resourceId=" + resourceId +
               '}';
    }
}