package com.perry.archmybatis.dao;

import com.perry.archmybatis.domain.UmsResourceCategoryExt;
import org.springframework.stereotype.Repository;

/**
 * @author perry
 * @description 资源分类dao
 * @date 2025/8/1 17:39
 */
@Repository
public interface UmsResourceCategoryDao {
    /**
     * 根据分类ID获取分类及对应资源（一对多的关系）
     */
    UmsResourceCategoryExt selectCategoryWithResources(Long id);
}
