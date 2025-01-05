package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductParam;

/**
 * 商品参数Service接口
 * 
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhProductParamService 
{
    /**
     * 查询商品参数
     * 
     * @param id 商品参数主键
     * @return 商品参数
     */
    public BzhProductParam selectBzhProductParamById(Long id);

    /**
     * 查询商品参数列表
     * 
     * @param bzhProductParam 商品参数
     * @return 商品参数集合
     */
    public List<BzhProductParam> selectBzhProductParamList(BzhProductParam bzhProductParam);

    /**
     * 新增商品参数
     * 
     * @param bzhProductParam 商品参数
     * @return 结果
     */
    public int insertBzhProductParam(BzhProductParam bzhProductParam);

    /**
     * 修改商品参数
     * 
     * @param bzhProductParam 商品参数
     * @return 结果
     */
    public int updateBzhProductParam(BzhProductParam bzhProductParam);

    /**
     * 批量删除商品参数
     * 
     * @param ids 需要删除的商品参数主键集合
     * @return 结果
     */
    public int deleteBzhProductParamByIds(Long[] ids);

    /**
     * 删除商品参数信息
     * 
     * @param id 商品参数主键
     * @return 结果
     */
    public int deleteBzhProductParamById(Long id);
}
