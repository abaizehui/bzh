package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhProductParam;

/**
 * 商品参数Mapper接口
 * 
 * @author bzh
 * @date 2025-01-04
 */
public interface BzhProductParamMapper 
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
     * 删除商品参数
     * 
     * @param id 商品参数主键
     * @return 结果
     */
    public int deleteBzhProductParamById(Long id);

    /**
     * 批量删除商品参数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhProductParamByIds(Long[] ids);
}
