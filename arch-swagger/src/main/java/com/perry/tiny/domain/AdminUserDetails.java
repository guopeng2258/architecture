package com.perry.tiny.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author perry
 * @description SpringSecurity用户信息封装类
 * @date 2025/8/4 19:12
 */
@Data
@EqualsAndHashCode
@Builder
public class AdminUserDetails implements UserDetails {
    private String username;
    private String password;
    private List<String> authorityList;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
