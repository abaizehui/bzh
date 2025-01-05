package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductMapper;
import com.bzh.business.domain.BzhProduct;
import com.bzh.business.service.IBzhProductService;

/**
 * 商品Service业务层处理
 * 
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductServiceImpl implements IBzhProductService 
{
    @Autowired
    private BzhProductMapper bzhProductMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public BzhProduct selectBzhProductById(Long id)
    {
        return bzhProductMapper.selectBzhProductById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param bzhProduct 商品
     * @return 商品
     */
    @Override
    public List<BzhProduct> selectBzhProductList(BzhProduct bzhProduct)
    {
        return bzhProductMapper.selectBzhProductList(bzhProduct);
    }

    /**
     * 新增商品
     * 
     * @param bzhProduct 商品
     * @return 结果
     */
    @Override
    public int insertBzhProduct(BzhProduct bzhProduct)
    {
        bzhProduct.setCreateTime(DateUtils.getNowDate());
        return bzhProductMapper.insertBzhProduct(bzhProduct);
    }

    /**
     * 修改商品
     * 
     * @param bzhProduct 商品
     * @return 结果
     */
    @Override
    public int updateBzhProduct(BzhProduct bzhProduct)
    {
        bzhProduct.setUpdateTime(DateUtils.getNowDate());
        return bzhProductMapper.updateBzhProduct(bzhProduct);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductByIds(Long[] ids)
    {
        return bzhProductMapper.deleteBzhProductByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductById(Long id)
    {
        return bzhProductMapper.deleteBzhProductById(id);
    }
}
