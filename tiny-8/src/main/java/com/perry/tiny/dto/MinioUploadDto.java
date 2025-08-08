package com.perry.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author perry
 * @description 文件上传返回结果
 * @date 2025/8/8 18:18
 */
@Data
@EqualsAndHashCode
public class MinioUploadDto {
    //文件访问地址
    private String url;
    //文件名称
    private String name;
}
