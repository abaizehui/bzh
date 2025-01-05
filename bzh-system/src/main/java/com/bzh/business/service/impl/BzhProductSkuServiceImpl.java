package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductSkuMapper;
import com.bzh.business.domain.BzhProductSku;
import com.bzh.business.service.IBzhProductSkuService;

/**
 * SKUService业务层处理
 * 
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductSkuServiceImpl implements IBzhProductSkuService 
{
    @Autowired
    private BzhProductSkuMapper bzhProductSkuMapper;

    /**
     * 查询SKU
     * 
     * @param id SKU主键
     * @return SKU
     */
    @Override
    public BzhProductSku selectBzhProductSkuById(Long id)
    {
        return bzhProductSkuMapper.selectBzhProductSkuById(id);
    }

    /**
     * 查询SKU列表
     * 
     * @param bzhProductSku SKU
     * @return SKU
     */
    @Override
    public List<BzhProductSku> selectBzhProductSkuList(BzhProductSku bzhProductSku)
    {
        return bzhProductSkuMapper.selectBzhProductSkuList(bzhProductSku);
    }

    /**
     * 新增SKU
     * 
     * @param bzhProductSku SKU
     * @return 结果
     */
    @Override
    public int insertBzhProductSku(BzhProductSku bzhProductSku)
    {
        bzhProductSku.setCreateTime(DateUtils.getNowDate());
        return bzhProductSkuMapper.insertBzhProductSku(bzhProductSku);
    }

    /**
     * 修改SKU
     * 
     * @param bzhProductSku SKU
     * @return 结果
     */
    @Override
    public int updateBzhProductSku(BzhProductSku bzhProductSku)
    {
        bzhProductSku.setUpdateTime(DateUtils.getNowDate());
        return bzhProductSkuMapper.updateBzhProductSku(bzhProductSku);
    }

    /**
     * 批量删除SKU
     * 
     * @param ids 需要删除的SKU主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSkuByIds(Long[] ids)
    {
        return bzhProductSkuMapper.deleteBzhProductSkuByIds(ids);
    }

    /**
     * 删除SKU信息
     * 
     * @param id SKU主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSkuById(Long id)
    {
        return bzhProductSkuMapper.deleteBzhProductSkuById(id);
    }
}
