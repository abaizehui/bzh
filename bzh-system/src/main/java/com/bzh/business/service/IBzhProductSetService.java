package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductSet;

/**
 * 商品套装Service接口
 *
 * @author bzh
 * @date 2025-03-31
 */
public interface IBzhProductSetService
{
    /**
     * 查询商品套装
     *
     * @param id 商品套装主键
     * @return 商品套装
     */
    public BzhProductSet selectBzhProductSetById(Long id);

    /**
     * 查询商品套装列表
     *
     * @param bzhProductSet 商品套装
     * @return 商品套装集合
     */
    public List<BzhProductSet> selectBzhProductSetList(BzhProductSet bzhProductSet);

    /**
     * 新增商品套装
     *
     * @param bzhProductSet 商品套装
     * @return 结果
     */
    public int insertBzhProductSet(BzhProductSet bzhProductSet);

    /**
     * 修改商品套装
     *
     * @param bzhProductSet 商品套装
     * @return 结果
     */
    public int updateBzhProductSet(BzhProductSet bzhProductSet);

    /**
     * 批量删除商品套装
     *
     * @param ids 需要删除的商品套装主键集合
     * @return 结果
     */
    public int deleteBzhProductSetByIds(Long[] ids);

    /**
     * 删除商品套装信息
     *
     * @param id 商品套装主键
     * @return 结果
     */
    public int deleteBzhProductSetById(Long id);

    public List<BzhProductSet> selectList(BzhProductSet bzhProductSet);

    public BzhProductSet getProductSetBySetId(Long setId);
}
