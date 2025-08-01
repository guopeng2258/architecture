package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 资源分类表
 */
public class UmsResourceCategory implements Serializable {
    
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
     * 分类名称
     */
    private String name;
    
    /**
     * 排序
     */
    private Integer sort;
    
    // 无参构造函数
    public UmsResourceCategory() {
    }
    
    // 全参构造函数
    public UmsResourceCategory(Long id, LocalDateTime createTime, String name, Integer sort) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.sort = sort;
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
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    @Override
    public String toString() {
        return "UmsResourceCategory{" +
               "id=" + id +
               ", createTime=" + createTime +
               ", name='" + name + '\'' +
               ", sort=" + sort +
               '}';
    }
}