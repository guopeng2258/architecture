package com.perry.archmybatis.dao;

import com.perry.archmybatis.domain.UmsResourceExt;
import com.perry.archmybatis.model.UmsResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author perry
 * @description UmsResource表查询
 * @date 2025/8/1 16:46
 */
@Repository
public interface UmsResourceDao {
    /**
     * 根据资源ID获取资源和分类信息
     */
    UmsResourceExt selectResourceWithCategory(Long id);
    /**
     * 根据资源ID获取资源和分类信息 使用association标签
     */
    UmsResourceExt selectResourceWithCategory2(Long id);
    /**
     * 根据分类ID获取资源列表
     */
    List<UmsResource> selectByCategoryId(Long categoryId);
}
