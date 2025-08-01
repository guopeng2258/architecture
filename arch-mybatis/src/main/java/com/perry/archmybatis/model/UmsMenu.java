package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 后台菜单表
 */
public class UmsMenu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 父级ID
     */
    private Long parentId;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 菜单名称
     */
    private String title;
    
    /**
     * 菜单级数
     */
    private Integer level;
    
    /**
     * 菜单排序
     */
    private Integer sort;
    
    /**
     * 前端名称
     */
    private String name;
    
    /**
     * 前端图标
     */
    private String icon;
    
    /**
     * 前端隐藏
     */
    private Integer hidden;
    
    // 无参构造函数
    public UmsMenu() {
    }
    
    // 全参构造函数
    public UmsMenu(Long id, Long parentId, LocalDateTime createTime, String title, 
                  Integer level, Integer sort, String name, String icon, Integer hidden) {
        this.id = id;
        this.parentId = parentId;
        this.createTime = createTime;
        this.title = title;
        this.level = level;
        this.sort = sort;
        this.name = name;
        this.icon = icon;
        this.hidden = hidden;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public Integer getHidden() {
        return hidden;
    }
    
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }
    
    @Override
    public String toString() {
        return "UmsMenu{" +
               "id=" + id +
               ", parentId=" + parentId +
               ", createTime=" + createTime +
               ", title='" + title + '\'' +
               ", level=" + level +
               ", sort=" + sort +
               ", name='" + name + '\'' +
               ", icon='" + icon + '\'' +
               ", hidden=" + hidden +
               '}';
    }
}