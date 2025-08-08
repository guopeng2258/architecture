package com.perry.tiny.service;

import com.perry.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @author perry
 * @description 会员商品浏览记录管理Service
 * @date 2025/8/7 18:06
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览记录
     */
    List<MemberReadHistory> list(Long memberId);
}
