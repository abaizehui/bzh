package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhProductSetItem;

/**
 * 商品套装关联Mapper接口
 * 
 * @author bzh
 * @date 2025-03-31
 */
public interface BzhProductSetItemMapper 
{
    /**
     * 查询商品套装关联
     * 
     * @param id 商品套装关联主键
     * @return 商品套装关联
     */
    public BzhProductSetItem selectBzhProductSetItemById(Long id);

    /**
     * 查询商品套装关联列表
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 商品套装关联集合
     */
    public List<BzhProductSetItem> selectBzhProductSetItemList(BzhProductSetItem bzhProductSetItem);

    /**
     * 新增商品套装关联
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 结果
     */
    public int insertBzhProductSetItem(BzhProductSetItem bzhProductSetItem);

    /**
     * 修改商品套装关联
     * 
     * @param bzhProductSetItem 商品套装关联
     * @return 结果
     */
    public int updateBzhProductSetItem(BzhProductSetItem bzhProductSetItem);

    /**
     * 删除商品套装关联
     * 
     * @param id 商品套装关联主键
     * @return 结果
     */
    public int deleteBzhProductSetItemById(Long id);

    /**
     * 批量删除商品套装关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhProductSetItemByIds(Long[] ids);
}
