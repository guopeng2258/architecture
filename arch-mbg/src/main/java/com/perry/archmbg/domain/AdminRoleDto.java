package com.perry.archmbg.domain;

import com.perry.archmbg.mbg.model.UmsRole;

import java.util.List;

/**
 * @author perry
 * @description
 * @date 2025/8/4 10:34
 */
public class AdminRoleDto {

    private List<UmsRole> roleList;

    public List<UmsRole> getRoleList(){
        return roleList;
    }

    public void setRoleList(List<UmsRole> roleList) {
        this.roleList = roleList;
    }
}
