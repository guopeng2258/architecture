package com.perry.archmybatis.model;

import java.io.Serializable;

/**
 * 后台角色菜单关系表
 */
public class UmsRoleMenuRelation implements Serializable {
    
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
     * 菜单ID
     */
    private Long menuId;
    
    // 无参构造函数
    public UmsRoleMenuRelation() {
    }
    
    // 全参构造函数
    public UmsRoleMenuRelation(Long id, Long roleId, Long menuId) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
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
    
    public Long getMenuId() {
        return menuId;
    }
    
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    
    @Override
    public String toString() {
        return "UmsRoleMenuRelation{" +
               "id=" + id +
               ", roleId=" + roleId +
               ", menuId=" + menuId +
               '}';
    }
}