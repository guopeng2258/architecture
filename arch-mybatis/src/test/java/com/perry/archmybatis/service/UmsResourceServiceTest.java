package com.perry.archmybatis.service;

import com.github.pagehelper.PageInfo;
import com.perry.archmybatis.ArchMybatisApplication;
import com.perry.archmybatis.model.UmsResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author perry
 * @description service测试类
 * @date 2025/8/1 18:11
 */
@SpringBootTest(classes = ArchMybatisApplication.class)
@Transactional

public class UmsResourceServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsResourceServiceTest.class);


    @Autowired
    private UmsResourceService umsResourceService;

@Test
public void testPage() {
    // 测试分页查询功能
    Integer pageNum = 1;
    Integer pageSize = 10;
    Long categoryId = 1L; // 假设存在ID为1的分类

    // 调用服务方法
    PageInfo<UmsResource> result = umsResourceService.page(pageNum, pageSize, categoryId);
    LOGGER.info("testPage total={},pages={},resourceList={}", result.getTotal(), result.getPages(), result.getList());

    // 断言结果不为空
    assertThat(result).isNotNull();

}

}
