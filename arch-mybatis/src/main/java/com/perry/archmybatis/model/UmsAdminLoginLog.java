package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 后台用户登录日志表
 */
public class UmsAdminLoginLog implements Serializable {
    
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
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * IP地址
     */
    private String ip;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 浏览器登录类型
     */
    private String userAgent;
    
    // 无参构造函数
    public UmsAdminLoginLog() {
    }
    
    // 全参构造函数
    public UmsAdminLoginLog(Long id, Long adminId, LocalDateTime createTime, String ip, 
                           String address, String userAgent) {
        this.id = id;
        this.adminId = adminId;
        this.createTime = createTime;
        this.ip = ip;
        this.address = address;
        this.userAgent = userAgent;
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
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public String getIp() {
        return ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
    
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    @Override
    public String toString() {
        return "UmsAdminLoginLog{" +
               "id=" + id +
               ", adminId=" + adminId +
               ", createTime=" + createTime +
               ", ip='" + ip + '\'' +
               ", address='" + address + '\'' +
               ", userAgent='" + userAgent + '\'' +
               '}';
    }
}