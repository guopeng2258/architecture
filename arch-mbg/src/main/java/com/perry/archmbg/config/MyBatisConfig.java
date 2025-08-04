package com.perry.archmbg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author perry
 * @description MyBatis配置类
 * @date 2025/8/4 09:42
 */
@Configuration
@MapperScan({"com.perry.archmbg.dao","com.perry.archmbg.mbg.mapper"})
public class MyBatisConfig {
}
