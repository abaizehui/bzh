package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhProductSetDetailImage;

/**
 * 商品套装详情图Mapper接口
 * 
 * @author bzh
 * @date 2025-04-02
 */
public interface BzhProductSetDetailImageMapper 
{
    /**
     * 查询商品套装详情图
     * 
     * @param id 商品套装详情图主键
     * @return 商品套装详情图
     */
    public BzhProductSetDetailImage selectBzhProductSetDetailImageById(Long id);

    /**
     * 查询商品套装详情图列表
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 商品套装详情图集合
     */
    public List<BzhProductSetDetailImage> selectBzhProductSetDetailImageList(BzhProductSetDetailImage bzhProductSetDetailImage);

    /**
     * 新增商品套装详情图
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 结果
     */
    public int insertBzhProductSetDetailImage(BzhProductSetDetailImage bzhProductSetDetailImage);

    /**
     * 修改商品套装详情图
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 结果
     */
    public int updateBzhProductSetDetailImage(BzhProductSetDetailImage bzhProductSetDetailImage);

    /**
     * 删除商品套装详情图
     * 
     * @param id 商品套装详情图主键
     * @return 结果
     */
    public int deleteBzhProductSetDetailImageById(Long id);

    /**
     * 批量删除商品套装详情图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhProductSetDetailImageByIds(Long[] ids);
}
