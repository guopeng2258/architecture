package com.perry.archmybatis.dao;

import com.perry.archmybatis.ArchMybatisApplication;
import com.perry.archmybatis.model.UmsResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.perry.archmybatis.domain.UmsResourceExt;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * UmsResourceDao测试类
 */
@SpringBootTest(classes = ArchMybatisApplication.class)
@Transactional
public class UmsResourceDaoTest {

    @Autowired
    private UmsResourceDao umsResourceDao;


    /**
     * 测试根据资源ID获取资源和分类信息
     */
    @Test
    public void testSelectResourceWithCategory() {
        Long id = 1L;
        UmsResourceExt result = umsResourceDao.selectResourceWithCategory(id);
        assertNotNull(result);
        System.out.println(result);
    }

    /**
     * 测试根据资源ID获取资源和分类信息 使用association标签
     */
    @org.junit.jupiter.api.Test
    public void testSelectResourceWithCategory2() {
        Long id = 1L;
        UmsResourceExt result = umsResourceDao.selectResourceWithCategory2(id);
        assertNotNull(result);
        System.out.println(result);
    }

    /**
     * 测试根据分类ID获取资源列表
     */
    @org.junit.jupiter.api.Test
    public void testSelectByCategoryId() {
        Long categoryId = 1L;
        List<UmsResource> result = umsResourceDao.selectByCategoryId(categoryId);
        assertNotNull(result);
        System.out.println(result);
    }

}