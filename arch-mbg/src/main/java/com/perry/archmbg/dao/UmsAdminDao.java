package com.perry.archmbg.dao;

import com.perry.archmbg.domain.AdminRoleDto;
import com.perry.archmbg.domain.ResourceWithCateDto;
import com.perry.archmbg.domain.RoleStatDto;
import com.perry.archmbg.mbg.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author perry
 * @description 自定义dao
 * @date 2025/8/4 10:33
 */
public interface UmsAdminDao {
    List<RoleStatDto> groupList();

    AdminRoleDto selectWithRoleList(@Param("id") Long id);

    List<UmsAdmin> subList(@Param("roleId") Long roleId);

    ResourceWithCateDto selectResourceWithCate(@Param("id")Long id);
}
