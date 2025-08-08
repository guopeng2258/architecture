package com.perry.tiny.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author perry
 * @description
 * @date 2025/8/5 16:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "UmsResource对象", description = "后台资源表")
public class UmsResource {

    private Long id;

    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;
}
