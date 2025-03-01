package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductConfig;

/**
 * 商品功能配置Service接口
 * 
 * @author bzh
 * @date 2025-03-01
 */
public interface IBzhProductConfigService 
{
    /**
     * 查询商品功能配置
     * 
     * @param id 商品功能配置主键
     * @return 商品功能配置
     */
    public BzhProductConfig selectBzhProductConfigById(Long id);

    /**
     * 查询商品功能配置列表
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 商品功能配置集合
     */
    public List<BzhProductConfig> selectBzhProductConfigList(BzhProductConfig bzhProductConfig);

    /**
     * 新增商品功能配置
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 结果
     */
    public int insertBzhProductConfig(BzhProductConfig bzhProductConfig);

    /**
     * 修改商品功能配置
     * 
     * @param bzhProductConfig 商品功能配置
     * @return 结果
     */
    public int updateBzhProductConfig(BzhProductConfig bzhProductConfig);

    /**
     * 批量删除商品功能配置
     * 
     * @param ids 需要删除的商品功能配置主键集合
     * @return 结果
     */
    public int deleteBzhProductConfigByIds(Long[] ids);

    /**
     * 删除商品功能配置信息
     * 
     * @param id 商品功能配置主键
     * @return 结果
     */
    public int deleteBzhProductConfigById(Long id);
}
