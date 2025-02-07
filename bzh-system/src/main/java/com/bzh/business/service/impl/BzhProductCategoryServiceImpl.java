package com.bzh.business.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bzh.business.domain.BzhStore;
import com.bzh.business.mapper.BzhStoreMapper;
import com.bzh.common.constant.Constants;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductCategoryMapper;
import com.bzh.business.domain.BzhProductCategory;
import com.bzh.business.service.IBzhProductCategoryService;

/**
 * 产品类目Service业务层处理
 *
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductCategoryServiceImpl implements IBzhProductCategoryService
{
    @Autowired
    private BzhProductCategoryMapper bzhProductCategoryMapper;
    @Autowired
    private BzhStoreMapper bzhStoreMapper;

    /**
     * 查询产品类目
     *
     * @param id 产品类目主键
     * @return 产品类目
     */
    @Override
    public BzhProductCategory selectBzhProductCategoryById(Long id)
    {
        return bzhProductCategoryMapper.selectBzhProductCategoryById(id);
    }

    /**
     * 查询产品类目列表
     *
     * @param bzhProductCategory 产品类目
     * @return 产品类目
     */
    @Override
    public List<BzhProductCategory> selectBzhProductCategoryList(BzhProductCategory bzhProductCategory)
    {
        List<BzhProductCategory> list = bzhProductCategoryMapper.selectBzhProductCategoryList(bzhProductCategory);
        List<BzhStore> bzhStores = bzhStoreMapper.selectBzhStoreList(new BzhStore());
        Map<Long, BzhStore> map = bzhStores.stream().collect(Collectors.toMap(BzhStore::getId, Function.identity()));
        list.forEach(item -> {
            item.setStoreName(map.get(item.getStoreId()).getStoreName());
        });
        return list;
    }

    /**
     * 新增产品类目
     *
     * @param bzhProductCategory 产品类目
     * @return 结果
     */
    @Override
    public int insertBzhProductCategory(BzhProductCategory bzhProductCategory)
    {
        bzhProductCategory.setCreateTime(DateUtils.getNowDate());
        return bzhProductCategoryMapper.insertBzhProductCategory(bzhProductCategory);
    }

    /**
     * 修改产品类目
     *
     * @param bzhProductCategory 产品类目
     * @return 结果
     */
    @Override
    public int updateBzhProductCategory(BzhProductCategory bzhProductCategory)
    {
        bzhProductCategory.setUpdateTime(DateUtils.getNowDate());
        return bzhProductCategoryMapper.updateBzhProductCategory(bzhProductCategory);
    }

    /**
     * 批量删除产品类目
     *
     * @param ids 需要删除的产品类目主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductCategoryByIds(Long[] ids)
    {
        return bzhProductCategoryMapper.deleteBzhProductCategoryByIds(ids);
    }

    /**
     * 删除产品类目信息
     *
     * @param id 产品类目主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductCategoryById(Long id)
    {
        return bzhProductCategoryMapper.deleteBzhProductCategoryById(id);
    }

    @Override
    public List<BzhProductCategory> getCategoryListByStoreId(Long storeId) {
        BzhProductCategory bzhProductCategory = new BzhProductCategory();
        bzhProductCategory.setStoreId(storeId);
        bzhProductCategory.setStatus(Constants.STATUS_YES);
        return bzhProductCategoryMapper.selectBzhProductCategoryList(bzhProductCategory);
    }
}
