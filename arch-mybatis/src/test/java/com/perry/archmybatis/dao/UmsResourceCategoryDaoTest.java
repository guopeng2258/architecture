package com.perry.archmybatis.dao;

import com.perry.archmybatis.ArchMybatisApplication;
import com.perry.archmybatis.domain.UmsResourceCategoryExt;
import com.perry.archmybatis.model.UmsResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * UmsResourceCategoryDao测试类
 */
@SpringBootTest(classes = ArchMybatisApplication.class)
@Transactional
public class UmsResourceCategoryDaoTest {

    @Autowired
    private UmsResourceCategoryDao umsResourceCategoryDao;

    /**
     * 测试根据分类ID获取分类及对应资源列表信息
     */
    @Test
    public void testSelectCategoryWithResources() {
        Long id = 1L;
        UmsResourceCategoryExt result = umsResourceCategoryDao.selectCategoryWithResources(id);
        assertNotNull(result);
        System.out.println(result);
        if (result.getResourceList() != null) {
            System.out.println("资源数量: " + result.getResourceList().size());
            result.getResourceList().forEach(resource -> System.out.println(resource.toString()));
        }
    }
}