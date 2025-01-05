package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhProductDetailImage;

/**
 * 商品详情图Mapper接口
 * 
 * @author bzh
 * @date 2025-01-04
 */
public interface BzhProductDetailImageMapper 
{
    /**
     * 查询商品详情图
     * 
     * @param id 商品详情图主键
     * @return 商品详情图
     */
    public BzhProductDetailImage selectBzhProductDetailImageById(Long id);

    /**
     * 查询商品详情图列表
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 商品详情图集合
     */
    public List<BzhProductDetailImage> selectBzhProductDetailImageList(BzhProductDetailImage bzhProductDetailImage);

    /**
     * 新增商品详情图
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 结果
     */
    public int insertBzhProductDetailImage(BzhProductDetailImage bzhProductDetailImage);

    /**
     * 修改商品详情图
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 结果
     */
    public int updateBzhProductDetailImage(BzhProductDetailImage bzhProductDetailImage);

    /**
     * 删除商品详情图
     * 
     * @param id 商品详情图主键
     * @return 结果
     */
    public int deleteBzhProductDetailImageById(Long id);

    /**
     * 批量删除商品详情图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhProductDetailImageByIds(Long[] ids);
}
