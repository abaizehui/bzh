package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductCategory;

/**
 * 产品类目Service接口
 *
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhProductCategoryService
{
    /**
     * 查询产品类目
     *
     * @param id 产品类目主键
     * @return 产品类目
     */
    public BzhProductCategory selectBzhProductCategoryById(Long id);

    /**
     * 查询产品类目列表
     *
     * @param bzhProductCategory 产品类目
     * @return 产品类目集合
     */
    public List<BzhProductCategory> selectBzhProductCategoryList(BzhProductCategory bzhProductCategory);

    /**
     * 新增产品类目
     *
     * @param bzhProductCategory 产品类目
     * @return 结果
     */
    public int insertBzhProductCategory(BzhProductCategory bzhProductCategory);

    /**
     * 修改产品类目
     *
     * @param bzhProductCategory 产品类目
     * @return 结果
     */
    public int updateBzhProductCategory(BzhProductCategory bzhProductCategory);

    /**
     * 批量删除产品类目
     *
     * @param ids 需要删除的产品类目主键集合
     * @return 结果
     */
    public int deleteBzhProductCategoryByIds(Long[] ids);

    /**
     * 删除产品类目信息
     *
     * @param id 产品类目主键
     * @return 结果
     */
    public int deleteBzhProductCategoryById(Long id);

    public List<BzhProductCategory> getCategoryListByStoreId(Long storeId);
}
