package com.perry.tiny.service;

import com.perry.tiny.common.api.CommonResult;
import com.perry.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author perry
 * @description 前台订单管理Service
 * @date 2025/8/8 15:58
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
