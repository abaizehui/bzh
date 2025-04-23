package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhStore;

/**
 * 门店Service接口
 *
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhStoreService
{
    /**
     * 查询门店
     *
     * @param id 门店主键
     * @return 门店
     */
    public BzhStore selectBzhStoreById(Long id);

    /**
     * 根据appId查询门店
     *
     * @param appId 门店主键
     * @return 门店
     */
    public BzhStore getStoreByAppId(String appId);

    /**
     * 查询门店列表
     *
     * @param bzhStore 门店
     * @return 门店集合
     */
    public List<BzhStore> selectBzhStoreList(BzhStore bzhStore);

    /**
     * 新增门店
     *
     * @param bzhStore 门店
     * @return 结果
     */
    public int insertBzhStore(BzhStore bzhStore);

    /**
     * 修改门店
     *
     * @param bzhStore 门店
     * @return 结果
     */
    public int updateBzhStore(BzhStore bzhStore);

    /**
     * 批量删除门店
     *
     * @param ids 需要删除的门店主键集合
     * @return 结果
     */
    public int deleteBzhStoreByIds(Long[] ids);

    /**
     * 删除门店信息
     *
     * @param id 门店主键
     * @return 结果
     */
    public int deleteBzhStoreById(Long id);
}
