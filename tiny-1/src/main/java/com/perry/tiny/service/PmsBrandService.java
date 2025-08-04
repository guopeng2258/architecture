package com.perry.tiny.service;

import com.perry.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author perry
 * @description
 * @date 2025/8/4 15:51
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
