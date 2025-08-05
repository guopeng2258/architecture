package com.perry.tiny.service;

import com.perry.tiny.common.api.CommonResult;

/**
 * @author perry
 * @description 会员管理Service
 * @date 2025/8/5 14:12
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码是否正确
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
