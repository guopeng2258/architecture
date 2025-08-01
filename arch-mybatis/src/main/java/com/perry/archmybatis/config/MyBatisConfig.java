package com.perry.archmybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author perry
 * @description MyBatis 配置类
 * @date 2025/8/1 09:50
 */
@Configuration
@MapperScan("com.perry.archmybatis.dao")
public class MyBatisConfig {
}
