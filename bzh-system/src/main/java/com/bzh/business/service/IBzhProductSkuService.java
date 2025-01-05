package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductSku;

/**
 * SKUService接口
 * 
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhProductSkuService 
{
    /**
     * 查询SKU
     * 
     * @param id SKU主键
     * @return SKU
     */
    public BzhProductSku selectBzhProductSkuById(Long id);

    /**
     * 查询SKU列表
     * 
     * @param bzhProductSku SKU
     * @return SKU集合
     */
    public List<BzhProductSku> selectBzhProductSkuList(BzhProductSku bzhProductSku);

    /**
     * 新增SKU
     * 
     * @param bzhProductSku SKU
     * @return 结果
     */
    public int insertBzhProductSku(BzhProductSku bzhProductSku);

    /**
     * 修改SKU
     * 
     * @param bzhProductSku SKU
     * @return 结果
     */
    public int updateBzhProductSku(BzhProductSku bzhProductSku);

    /**
     * 批量删除SKU
     * 
     * @param ids 需要删除的SKU主键集合
     * @return 结果
     */
    public int deleteBzhProductSkuByIds(Long[] ids);

    /**
     * 删除SKU信息
     * 
     * @param id SKU主键
     * @return 结果
     */
    public int deleteBzhProductSkuById(Long id);
}
