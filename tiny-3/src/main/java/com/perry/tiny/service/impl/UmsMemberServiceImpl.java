package com.perry.tiny.service.impl;

import cn.hutool.core.util.StrUtil;
import com.perry.tiny.common.api.CommonResult;
import com.perry.tiny.service.RedisService;
import com.perry.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author perry
 * @description 会员管理Service实现类
 * @date 2025/8/5 14:13
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    // 验证码在Redis中的前缀key
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    // 验证码过期时间（秒）
    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTH_CODE;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        // 生成6位随机数字验证码
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        // 将验证码存入Redis并设置过期时间
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, REDIS_KEY_EXPIRE_AUTH_CODE);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        // 检查验证码是否为空
        if (StrUtil.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        // 从Redis中获取真实的验证码
        String realAuthCode =(String) redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        // 比较输入的验证码与真实验证码是否一致
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
