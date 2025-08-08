package com.perry.tiny.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author perry
 * @description   Minio bucket访问策略配置
 * @date 2025/8/8 18:15
 */
@Data
@EqualsAndHashCode
@Builder
public class BucketPolicyConfigDto {
    private String Version;
    private List<Statement> Statement;

    @Data
    @Builder
    @EqualsAndHashCode
    public static class Statement {
        private String Effect;
        private String Principal;
        private String Action;
        private String Resource;
    }
}
