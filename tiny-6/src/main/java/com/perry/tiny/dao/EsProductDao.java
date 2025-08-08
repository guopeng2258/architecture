package com.perry.tiny.dao;

import com.perry.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author perry
 * @description 搜索商品 自定义DAO
 * @date 2025/8/6 14:10
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
