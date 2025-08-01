package com.perry.archmybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.perry.archmybatis.dao.UmsResourceDao;
import com.perry.archmybatis.model.UmsResource;
import com.perry.archmybatis.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author perry
 * @description UmsResourceService的Service接口实现类
 * @date 2025/8/1 17:59
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private UmsResourceDao umsResourceDao;

    @Override
    public PageInfo<UmsResource> page(Integer pageNum, Integer pageSize, Long categoryId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsResource> resourceList = umsResourceDao.selectByCategoryId(categoryId);
        PageInfo<UmsResource> pageInfo = new PageInfo<>(resourceList);
        return pageInfo;
    }
}
