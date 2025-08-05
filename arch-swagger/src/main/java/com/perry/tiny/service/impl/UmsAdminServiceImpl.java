package com.perry.tiny.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.perry.tiny.common.utils.JwtTokenUtil;
import com.perry.tiny.domain.AdminUserDetails;
import com.perry.tiny.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author perry
 * @description
 * @date 2025/8/4 19:24
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    /**
     * 模拟数据库数据
     */
    private List<AdminUserDetails> adminUserDetailsList = new ArrayList<>();

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        adminUserDetailsList.add(AdminUserDetails.builder()
                .username("admin").password(passwordEncoder.encode("123456"))
                .authorityList(CollUtil.toList("ROLE_ADMIN"))
                .build());
        adminUserDetailsList.add(AdminUserDetails.builder()
                .username("perry").password(passwordEncoder.encode("123456"))
                .authorityList(CollUtil.toList("ROLE_USER"))
                .build());
    }

    @Override
    public AdminUserDetails getAdminByUsername(String username) {
        List<AdminUserDetails> findList = adminUserDetailsList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(findList)) {
            return findList.get(0);
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = getAdminByUsername(username);
            if (userDetails == null) {
                return null;
            }
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (Exception e) {
            log.warn("登录异常:{}",e.getMessage());
        }
        return token;
    }
}
