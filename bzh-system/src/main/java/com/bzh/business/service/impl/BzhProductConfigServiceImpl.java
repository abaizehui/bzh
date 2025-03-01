package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductConfigMapper;
import com.bzh.business.domain.BzhProductConfig;
import com.bzh.business.service.IBzhProductConfigService;

/**
 * 商品功能配置Service业务层处理
 * 
 * @author bzh
 * @date 2025-03-01
 */
@Service
public class BzhProductConfigServiceImpl implements IBzhProductConfigService 
{
    @Autowired
    private BzhProductConfigMapper bzhProductConfigMapper;

    /**
     * 查询商品功能配置
     * 
     * @param id 商品功能配置主键
     * @return 商品功能配置
     */
    @Override
    public BzhProductConfig selectBzhProductConfigById(Long id)
    {
        return bzhProductConfigMapper.selectBzhProductConfigById(id);
    }

    /**
     * 查询商品功能配置列表
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 商品功能配置
     */
    @Override
    public List<BzhProductConfig> selectBzhProductConfigList(BzhProductConfig bzhProductConfig)
    {
        return bzhProductConfigMapper.selectBzhProductConfigList(bzhProductConfig);
    }

    /**
     * 新增商品功能配置
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 结果
     */
    @Override
    public int insertBzhProductConfig(BzhProductConfig bzhProductConfig)
    {
        bzhProductConfig.setCreateTime(DateUtils.getNowDate());
        return bzhProductConfigMapper.insertBzhProductConfig(bzhProductConfig);
    }

    /**
     * 修改商品功能配置
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 结果
     */
    @Override
    public int updateBzhProductConfig(BzhProductConfig bzhProductConfig)
    {
        bzhProductConfig.setUpdateTime(DateUtils.getNowDate());
        return bzhProductConfigMapper.updateBzhProductConfig(bzhProductConfig);
    }

    /**
     * 批量删除商品功能配置
     * 
     * @param ids 需要删除的商品功能配置主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductConfigByIds(Long[] ids)
    {
        return bzhProductConfigMapper.deleteBzhProductConfigByIds(ids);
    }

    /**
     * 删除商品功能配置信息
     * 
     * @param id 商品功能配置主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductConfigById(Long id)
    {
        return bzhProductConfigMapper.deleteBzhProductConfigById(id);
    }
}
