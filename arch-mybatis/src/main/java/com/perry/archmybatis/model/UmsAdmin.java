package com.perry.archmybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 后台用户表
 */
public class UmsAdmin implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 头像
     */
    private String icon;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 备注信息
     */
    private String note;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 最后登录时间
     */
    private LocalDateTime loginTime;
    
    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
    
    // 无参构造函数
    public UmsAdmin() {
    }
    
    // 全参构造函数
    public UmsAdmin(Long id, String username, String password, String icon, String email,
                   String nickName, String note, LocalDateTime createTime, 
                   LocalDateTime loginTime, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.icon = icon;
        this.email = email;
        this.nickName = nickName;
        this.note = note;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.status = status;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public LocalDateTime getLoginTime() {
        return loginTime;
    }
    
    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "UmsAdmin{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", icon='" + icon + '\'' +
               ", email='" + email + '\'' +
               ", nickName='" + nickName + '\'' +
               ", note='" + note + '\'' +
               ", createTime=" + createTime +
               ", loginTime=" + loginTime +
               ", status=" + status +
               '}';
    }
}