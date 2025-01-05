package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductDetailImageMapper;
import com.bzh.business.domain.BzhProductDetailImage;
import com.bzh.business.service.IBzhProductDetailImageService;

/**
 * 商品详情图Service业务层处理
 * 
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductDetailImageServiceImpl implements IBzhProductDetailImageService 
{
    @Autowired
    private BzhProductDetailImageMapper bzhProductDetailImageMapper;

    /**
     * 查询商品详情图
     * 
     * @param id 商品详情图主键
     * @return 商品详情图
     */
    @Override
    public BzhProductDetailImage selectBzhProductDetailImageById(Long id)
    {
        return bzhProductDetailImageMapper.selectBzhProductDetailImageById(id);
    }

    /**
     * 查询商品详情图列表
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 商品详情图
     */
    @Override
    public List<BzhProductDetailImage> selectBzhProductDetailImageList(BzhProductDetailImage bzhProductDetailImage)
    {
        return bzhProductDetailImageMapper.selectBzhProductDetailImageList(bzhProductDetailImage);
    }

    /**
     * 新增商品详情图
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 结果
     */
    @Override
    public int insertBzhProductDetailImage(BzhProductDetailImage bzhProductDetailImage)
    {
        bzhProductDetailImage.setCreateTime(DateUtils.getNowDate());
        return bzhProductDetailImageMapper.insertBzhProductDetailImage(bzhProductDetailImage);
    }

    /**
     * 修改商品详情图
     * 
     * @param bzhProductDetailImage 商品详情图
     * @return 结果
     */
    @Override
    public int updateBzhProductDetailImage(BzhProductDetailImage bzhProductDetailImage)
    {
        bzhProductDetailImage.setUpdateTime(DateUtils.getNowDate());
        return bzhProductDetailImageMapper.updateBzhProductDetailImage(bzhProductDetailImage);
    }

    /**
     * 批量删除商品详情图
     * 
     * @param ids 需要删除的商品详情图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductDetailImageByIds(Long[] ids)
    {
        return bzhProductDetailImageMapper.deleteBzhProductDetailImageByIds(ids);
    }

    /**
     * 删除商品详情图信息
     * 
     * @param id 商品详情图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductDetailImageById(Long id)
    {
        return bzhProductDetailImageMapper.deleteBzhProductDetailImageById(id);
    }
}
