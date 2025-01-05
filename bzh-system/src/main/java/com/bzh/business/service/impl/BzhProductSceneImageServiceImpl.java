package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductSceneImageMapper;
import com.bzh.business.domain.BzhProductSceneImage;
import com.bzh.business.service.IBzhProductSceneImageService;

/**
 * 商品实景图Service业务层处理
 * 
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductSceneImageServiceImpl implements IBzhProductSceneImageService 
{
    @Autowired
    private BzhProductSceneImageMapper bzhProductSceneImageMapper;

    /**
     * 查询商品实景图
     * 
     * @param id 商品实景图主键
     * @return 商品实景图
     */
    @Override
    public BzhProductSceneImage selectBzhProductSceneImageById(Long id)
    {
        return bzhProductSceneImageMapper.selectBzhProductSceneImageById(id);
    }

    /**
     * 查询商品实景图列表
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 商品实景图
     */
    @Override
    public List<BzhProductSceneImage> selectBzhProductSceneImageList(BzhProductSceneImage bzhProductSceneImage)
    {
        return bzhProductSceneImageMapper.selectBzhProductSceneImageList(bzhProductSceneImage);
    }

    /**
     * 新增商品实景图
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 结果
     */
    @Override
    public int insertBzhProductSceneImage(BzhProductSceneImage bzhProductSceneImage)
    {
        bzhProductSceneImage.setCreateTime(DateUtils.getNowDate());
        return bzhProductSceneImageMapper.insertBzhProductSceneImage(bzhProductSceneImage);
    }

    /**
     * 修改商品实景图
     * 
     * @param bzhProductSceneImage 商品实景图
     * @return 结果
     */
    @Override
    public int updateBzhProductSceneImage(BzhProductSceneImage bzhProductSceneImage)
    {
        bzhProductSceneImage.setUpdateTime(DateUtils.getNowDate());
        return bzhProductSceneImageMapper.updateBzhProductSceneImage(bzhProductSceneImage);
    }

    /**
     * 批量删除商品实景图
     * 
     * @param ids 需要删除的商品实景图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSceneImageByIds(Long[] ids)
    {
        return bzhProductSceneImageMapper.deleteBzhProductSceneImageByIds(ids);
    }

    /**
     * 删除商品实景图信息
     * 
     * @param id 商品实景图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSceneImageById(Long id)
    {
        return bzhProductSceneImageMapper.deleteBzhProductSceneImageById(id);
    }
}
