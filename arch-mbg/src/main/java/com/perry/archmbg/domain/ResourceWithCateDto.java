package com.perry.archmbg.domain;

import com.perry.archmbg.mbg.model.UmsResource;
import com.perry.archmbg.mbg.model.UmsResourceCategory;

/**
 * @author perry
 * @description
 * @date 2025/8/4 10:35
 */
public class ResourceWithCateDto extends UmsResource {

    private UmsResourceCategory resourceCategory;

    public UmsResourceCategory getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(UmsResourceCategory resourceCategory) {
        this.resourceCategory = resourceCategory;
    }
}
