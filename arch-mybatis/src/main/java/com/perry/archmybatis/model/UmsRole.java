package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 后台用户角色表
 */
public class UmsRole implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 后台用户数量
     */
    private Integer adminCount;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;
    
    /**
     * 排序
     */
    private Integer sort;
    
    // 无参构造函数
    public UmsRole() {
    }
    
    // 全参构造函数
    public UmsRole(Long id, String name, String description, Integer adminCount, 
                  LocalDateTime createTime, Integer status, Integer sort) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adminCount = adminCount;
        this.createTime = createTime;
        this.status = status;
        this.sort = sort;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getAdminCount() {
        return adminCount;
    }
    
    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    @Override
    public String toString() {
        return "UmsRole{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", adminCount=" + adminCount +
               ", createTime=" + createTime +
               ", status=" + status +
               ", sort=" + sort +
               '}';
    }
}