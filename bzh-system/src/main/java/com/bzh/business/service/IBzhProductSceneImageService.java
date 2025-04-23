package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProductSceneImage;

/**
 * 商品实景图Service接口
 * 
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhProductSceneImageService 
{
    /**
     * 查询商品实景图
     * 
     * @param id 商品实景图主键
     * @return 商品实景图
     */
    public BzhProductSceneImage selectBzhProductSceneImageById(Long id);

    /**
     * 查询商品实景图列表
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 商品实景图集合
     */
    public List<BzhProductSceneImage> selectBzhProductSceneImageList(BzhProductSceneImage bzhProductSceneImage);

    /**
     * 新增商品实景图
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 结果
     */
    public int insertBzhProductSceneImage(BzhProductSceneImage bzhProductSceneImage);

    /**
     * 修改商品实景图
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 结果
     */
    public int updateBzhProductSceneImage(BzhProductSceneImage bzhProductSceneImage);

    /**
     * 批量删除商品实景图
     * 
     * @param ids 需要删除的商品实景图主键集合
     * @return 结果
     */
    public int deleteBzhProductSceneImageByIds(Long[] ids);

    /**
     * 删除商品实景图信息
     * 
     * @param id 商品实景图主键
     * @return 结果
     */
    public int deleteBzhProductSceneImageById(Long id);
}
