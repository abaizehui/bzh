package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhStoreMapper;
import com.bzh.business.domain.BzhStore;
import com.bzh.business.service.IBzhStoreService;

/**
 * 门店Service业务层处理
 *
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhStoreServiceImpl implements IBzhStoreService
{
    @Autowired
    private BzhStoreMapper bzhStoreMapper;

    /**
     * 查询门店
     *
     * @param id 门店主键
     * @return 门店
     */
    @Override
    public BzhStore selectBzhStoreById(Long id)
    {
        return bzhStoreMapper.selectBzhStoreById(id);
    }

    /**
     * 根据appid查询门店
     *
     * @param appId 门店主键
     * @return 门店
     */
    @Override
    public BzhStore getStoreByAppId(String appId)
    {
        return bzhStoreMapper.getStoreByAppId(appId);
    }

    /**
     * 查询门店列表
     *
     * @param bzhStore 门店
     * @return 门店
     */
    @Override
    public List<BzhStore> selectBzhStoreList(BzhStore bzhStore)
    {
        return bzhStoreMapper.selectBzhStoreList(bzhStore);
    }

    /**
     * 新增门店
     *
     * @param bzhStore 门店
     * @return 结果
     */
    @Override
    public int insertBzhStore(BzhStore bzhStore)
    {
        bzhStore.setCreateTime(DateUtils.getNowDate());
        return bzhStoreMapper.insertBzhStore(bzhStore);
    }

    /**
     * 修改门店
     *
     * @param bzhStore 门店
     * @return 结果
     */
    @Override
    public int updateBzhStore(BzhStore bzhStore)
    {
        bzhStore.setUpdateTime(DateUtils.getNowDate());
        return bzhStoreMapper.updateBzhStore(bzhStore);
    }

    /**
     * 批量删除门店
     *
     * @param ids 需要删除的门店主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreByIds(Long[] ids)
    {
        return bzhStoreMapper.deleteBzhStoreByIds(ids);
    }

    /**
     * 删除门店信息
     *
     * @param id 门店主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreById(Long id)
    {
        return bzhStoreMapper.deleteBzhStoreById(id);
    }
}
