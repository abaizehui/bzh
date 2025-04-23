package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhCarouselImages;

/**
 * 轮播图Service接口
 *
 * @author bzh
 * @date 2025-01-06
 */
public interface IBzhCarouselImagesService
{
    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    public BzhCarouselImages selectBzhCarouselImagesById(Long id);

    /**
     * 查询轮播图列表
     *
     * @param bzhCarouselImages 轮播图
     * @return 轮播图集合
     */
    public List<BzhCarouselImages> selectBzhCarouselImagesList(BzhCarouselImages bzhCarouselImages);

    /**
     * 查询轮播图列表
     *
     * @param bzhCarouselImages 轮播图
     * @return 轮播图集合
     */
    public List<BzhCarouselImages> selectList(BzhCarouselImages bzhCarouselImages);

    /**
     * 新增轮播图
     *
     * @param bzhCarouselImages 轮播图
     * @return 结果
     */
    public int insertBzhCarouselImages(BzhCarouselImages bzhCarouselImages);

    /**
     * 修改轮播图
     *
     * @param bzhCarouselImages 轮播图
     * @return 结果
     */
    public int updateBzhCarouselImages(BzhCarouselImages bzhCarouselImages);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的轮播图主键集合
     * @return 结果
     */
    public int deleteBzhCarouselImagesByIds(Long[] ids);

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteBzhCarouselImagesById(Long id);
}
