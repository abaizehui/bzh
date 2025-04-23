package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductSetDetailImageMapper;
import com.bzh.business.domain.BzhProductSetDetailImage;
import com.bzh.business.service.IBzhProductSetDetailImageService;

/**
 * 商品套装详情图Service业务层处理
 * 
 * @author bzh
 * @date 2025-04-02
 */
@Service
public class BzhProductSetDetailImageServiceImpl implements IBzhProductSetDetailImageService 
{
    @Autowired
    private BzhProductSetDetailImageMapper bzhProductSetDetailImageMapper;

    /**
     * 查询商品套装详情图
     * 
     * @param id 商品套装详情图主键
     * @return 商品套装详情图
     */
    @Override
    public BzhProductSetDetailImage selectBzhProductSetDetailImageById(Long id)
    {
        return bzhProductSetDetailImageMapper.selectBzhProductSetDetailImageById(id);
    }

    /**
     * 查询商品套装详情图列表
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 商品套装详情图
     */
    @Override
    public List<BzhProductSetDetailImage> selectBzhProductSetDetailImageList(BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        return bzhProductSetDetailImageMapper.selectBzhProductSetDetailImageList(bzhProductSetDetailImage);
    }

    /**
     * 新增商品套装详情图
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 结果
     */
    @Override
    public int insertBzhProductSetDetailImage(BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        bzhProductSetDetailImage.setCreateTime(DateUtils.getNowDate());
        return bzhProductSetDetailImageMapper.insertBzhProductSetDetailImage(bzhProductSetDetailImage);
    }

    /**
     * 修改商品套装详情图
     * 
     * @param bzhProductSetDetailImage 商品套装详情图
     * @return 结果
     */
    @Override
    public int updateBzhProductSetDetailImage(BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        bzhProductSetDetailImage.setUpdateTime(DateUtils.getNowDate());
        return bzhProductSetDetailImageMapper.updateBzhProductSetDetailImage(bzhProductSetDetailImage);
    }

    /**
     * 批量删除商品套装详情图
     * 
     * @param ids 需要删除的商品套装详情图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetDetailImageByIds(Long[] ids)
    {
        return bzhProductSetDetailImageMapper.deleteBzhProductSetDetailImageByIds(ids);
    }

    /**
     * 删除商品套装详情图信息
     * 
     * @param id 商品套装详情图主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetDetailImageById(Long id)
    {
        return bzhProductSetDetailImageMapper.deleteBzhProductSetDetailImageById(id);
    }
}
