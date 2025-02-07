package com.bzh.business.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bzh.business.domain.BzhProductCategory;
import com.bzh.business.domain.BzhStore;
import com.bzh.business.mapper.BzhProductCategoryMapper;
import com.bzh.business.mapper.BzhStoreMapper;
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
    @Autowired
    private BzhStoreMapper bzhStoreMapper;
    @Autowired
    private BzhProductCategoryMapper bzhProductCategoryMapper;

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
        List<BzhProduct> list = bzhProductMapper.selectBzhProductList(bzhProduct);
        List<BzhStore> bzhStores = bzhStoreMapper.selectBzhStoreList(new BzhStore());
        Map<Long, BzhStore> mapBzhStore = bzhStores.stream().collect(Collectors.toMap(BzhStore::getId, Function.identity()));
        List<BzhProductCategory> bzhProductCategories = bzhProductCategoryMapper.selectBzhProductCategoryList(new BzhProductCategory());
        Map<Long, BzhProductCategory> mapBzhProductCategory = bzhProductCategories.stream().collect(Collectors.toMap(BzhProductCategory::getId, Function.identity()));

        list.forEach(item -> {
            item.setStoreName(mapBzhStore.get(item.getStoreId()).getStoreName());
            item.setCategoryName(mapBzhProductCategory.get(item.getCategoryId()).getCategoryName());
        });
        return list;
    }

    /**
     * 查询商品列表
     *
     * @param bzhProduct 商品
     * @return 商品
     */
    @Override
    public List<BzhProduct> selectList(BzhProduct bzhProduct)
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
