package com.perry.tiny.component;

import com.perry.tiny.common.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author perry
 * @description jwt登录授权过滤器
 * @date 2025/8/4 19:56
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
        /*
        // 从请求头中获取token
        String authHeader = request.getHeader(this.tokenHeader);
        // 判断token是否以指定前缀开始
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // 截取token字符串（去除前缀部分）
            String authToken = authHeader.substring(this.tokenHead.length());
            // 从token中解析出用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}", username);
            // 如果用户名存在且当前上下文中没有认证信息
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据用户名获取用户详情
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                // 验证token是否有效
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    // 创建认证对象
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    // 设置认证详情
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user:{}", username);
                    // 将认证信息存入安全上下文
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        */

        // 继续执行过滤器链
        filterChain.doFilter(request, response);
    }
}