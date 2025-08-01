package com.perry.archmybatis.domain;

import com.perry.archmybatis.model.UmsResource;
import com.perry.archmybatis.model.UmsResourceCategory;

import java.util.List;

/**
 * @author perry
 * @description UmsResourceCategory扩展类
 * @date 2025/8/1 10:47
 */
public class UmsResourceCategoryExt extends UmsResourceCategory {
    private List<UmsResource> resourceList;

    public List<UmsResource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<UmsResource> resourceList) {
        this.resourceList = resourceList;
    }
}
