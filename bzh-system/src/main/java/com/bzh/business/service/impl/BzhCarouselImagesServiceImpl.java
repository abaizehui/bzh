package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhCarouselImagesMapper;
import com.bzh.business.domain.BzhCarouselImages;
import com.bzh.business.service.IBzhCarouselImagesService;

/**
 * 轮播图Service业务层处理
 * 
 * @author bzh
 * @date 2025-01-06
 */
@Service
public class BzhCarouselImagesServiceImpl implements IBzhCarouselImagesService 
{
    @Autowired
    private BzhCarouselImagesMapper bzhCarouselImagesMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public BzhCarouselImages selectBzhCarouselImagesById(Long id)
    {
        return bzhCarouselImagesMapper.selectBzhCarouselImagesById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param bzhCarouselImages 轮播图
     * @return 轮播图
     */
    @Override
    public List<BzhCarouselImages> selectBzhCarouselImagesList(BzhCarouselImages bzhCarouselImages)
    {
        return bzhCarouselImagesMapper.selectBzhCarouselImagesList(bzhCarouselImages);
    }

    /**
     * 新增轮播图
     * 
     * @param bzhCarouselImages 轮播图
     * @return 结果
     */
    @Override
    public int insertBzhCarouselImages(BzhCarouselImages bzhCarouselImages)
    {
        bzhCarouselImages.setCreateTime(DateUtils.getNowDate());
        return bzhCarouselImagesMapper.insertBzhCarouselImages(bzhCarouselImages);
    }

    /**
     * 修改轮播图
     * 
     * @param bzhCarouselImages 轮播图
     * @return 结果
     */
    @Override
    public int updateBzhCarouselImages(BzhCarouselImages bzhCarouselImages)
    {
        bzhCarouselImages.setUpdateTime(DateUtils.getNowDate());
        return bzhCarouselImagesMapper.updateBzhCarouselImages(bzhCarouselImages);
    }

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteBzhCarouselImagesByIds(Long[] ids)
    {
        return bzhCarouselImagesMapper.deleteBzhCarouselImagesByIds(ids);
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteBzhCarouselImagesById(Long id)
    {
        return bzhCarouselImagesMapper.deleteBzhCarouselImagesById(id);
    }
}
