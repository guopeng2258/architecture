package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 后台资源表
 */
public class UmsResource implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 资源名称
     */
    private String name;
    
    /**
     * 资源URL
     */
    private String url;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 资源分类ID
     */
    private Long categoryId;
    
    // 无参构造函数
    public UmsResource() {
    }
    
    // 全参构造函数
    public UmsResource(Long id, LocalDateTime createTime, String name, String url, 
                      String description, Long categoryId) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.url = url;
        this.description = description;
        this.categoryId = categoryId;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    @Override
    public String toString() {
        return "UmsResource{" +
               "id=" + id +
               ", createTime=" + createTime +
               ", name='" + name + '\'' +
               ", url='" + url + '\'' +
               ", description='" + description + '\'' +
               ", categoryId=" + categoryId +
               '}';
    }
}