package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductSetItemMapper;
import com.bzh.business.domain.BzhProductSetItem;
import com.bzh.business.service.IBzhProductSetItemService;

/**
 * 商品套装关联Service业务层处理
 * 
 * @author bzh
 * @date 2025-03-31
 */
@Service
public class BzhProductSetItemServiceImpl implements IBzhProductSetItemService 
{
    @Autowired
    private BzhProductSetItemMapper bzhProductSetItemMapper;

    /**
     * 查询商品套装关联
     * 
     * @param id 商品套装关联主键
     * @return 商品套装关联
     */
    @Override
    public BzhProductSetItem selectBzhProductSetItemById(Long id)
    {
        return bzhProductSetItemMapper.selectBzhProductSetItemById(id);
    }

    /**
     * 查询商品套装关联列表
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 商品套装关联
     */
    @Override
    public List<BzhProductSetItem> selectBzhProductSetItemList(BzhProductSetItem bzhProductSetItem)
    {
        return bzhProductSetItemMapper.selectBzhProductSetItemList(bzhProductSetItem);
    }

    /**
     * 新增商品套装关联
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 结果
     */
    @Override
    public int insertBzhProductSetItem(BzhProductSetItem bzhProductSetItem)
    {
        bzhProductSetItem.setCreateTime(DateUtils.getNowDate());
        return bzhProductSetItemMapper.insertBzhProductSetItem(bzhProductSetItem);
    }

    /**
     * 修改商品套装关联
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 结果
     */
    @Override
    public int updateBzhProductSetItem(BzhProductSetItem bzhProductSetItem)
    {
        bzhProductSetItem.setUpdateTime(DateUtils.getNowDate());
        return bzhProductSetItemMapper.updateBzhProductSetItem(bzhProductSetItem);
    }

    /**
     * 批量删除商品套装关联
     * 
     * @param ids 需要删除的商品套装关联主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetItemByIds(Long[] ids)
    {
        return bzhProductSetItemMapper.deleteBzhProductSetItemByIds(ids);
    }

    /**
     * 删除商品套装关联信息
     * 
     * @param id 商品套装关联主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetItemById(Long id)
    {
        return bzhProductSetItemMapper.deleteBzhProductSetItemById(id);
    }
}
