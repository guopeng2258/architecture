package com.perry.archmbg.service;

import com.perry.archmbg.domain.AdminRoleDto;
import com.perry.archmbg.domain.ResourceWithCateDto;
import com.perry.archmbg.domain.RoleStatDto;
import com.perry.archmbg.mbg.model.UmsAdmin;

import java.util.List;

/**
 * @author perry
 * @description
 * @date 2025/8/4 10:24
 */
public interface UmsAdminService {
    void create(UmsAdmin entity);

    void update(UmsAdmin entity);

    void delete(Long id);

    UmsAdmin select(Long id);

    List<UmsAdmin> listAll(Integer pageNum, Integer pageSize);

    List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList);

    List<UmsAdmin> subList(Long roleId);

    List<RoleStatDto> groupList();

    void deleteByUsername(String username);

    void updateByIds(List<Long> ids,Integer status);

    AdminRoleDto selectWithRoleList(Long id);

    ResourceWithCateDto selectResourceWithCate(Long id);
}
