package com.perry.archmybatis.service;

import com.github.pagehelper.PageInfo;
import com.perry.archmybatis.model.UmsResource;

/**
 * @author perry
 * @description UmsResourceService的service接口
 * @date 2025/8/1 18:01
 */
public interface UmsResourceService {

    /**
     * 分页查询 根据资源分类查询资源列表 带分页
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param categoryId 资源分类ID
     * @return 列表
     */
    PageInfo<UmsResource> page(Integer pageNum, Integer pageSize, Long categoryId);

}
