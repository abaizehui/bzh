package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductParamMapper;
import com.bzh.business.domain.BzhProductParam;
import com.bzh.business.service.IBzhProductParamService;

/**
 * 商品参数Service业务层处理
 * 
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductParamServiceImpl implements IBzhProductParamService 
{
    @Autowired
    private BzhProductParamMapper bzhProductParamMapper;

    /**
     * 查询商品参数
     * 
     * @param id 商品参数主键
     * @return 商品参数
     */
    @Override
    public BzhProductParam selectBzhProductParamById(Long id)
    {
        return bzhProductParamMapper.selectBzhProductParamById(id);
    }

    /**
     * 查询商品参数列表
     * 
     * @param bzhProductParam 商品参数
     * @return 商品参数
     */
    @Override
    public List<BzhProductParam> selectBzhProductParamList(BzhProductParam bzhProductParam)
    {
        return bzhProductParamMapper.selectBzhProductParamList(bzhProductParam);
    }

    /**
     * 新增商品参数
     * 
     * @param bzhProductParam 商品参数
     * @return 结果
     */
    @Override
    public int insertBzhProductParam(BzhProductParam bzhProductParam)
    {
        bzhProductParam.setCreateTime(DateUtils.getNowDate());
        return bzhProductParamMapper.insertBzhProductParam(bzhProductParam);
    }

    /**
     * 修改商品参数
     * 
     * @param bzhProductParam 商品参数
     * @return 结果
     */
    @Override
    public int updateBzhProductParam(BzhProductParam bzhProductParam)
    {
        bzhProductParam.setUpdateTime(DateUtils.getNowDate());
        return bzhProductParamMapper.updateBzhProductParam(bzhProductParam);
    }

    /**
     * 批量删除商品参数
     * 
     * @param ids 需要删除的商品参数主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductParamByIds(Long[] ids)
    {
        return bzhProductParamMapper.deleteBzhProductParamByIds(ids);
    }

    /**
     * 删除商品参数信息
     * 
     * @param id 商品参数主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductParamById(Long id)
    {
        return bzhProductParamMapper.deleteBzhProductParamById(id);
    }
}
