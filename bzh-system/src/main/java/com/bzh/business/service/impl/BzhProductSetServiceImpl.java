package com.bzh.business.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bzh.business.domain.BzhProductSetDetailImage;
import com.bzh.business.domain.BzhStore;
import com.bzh.business.mapper.BzhProductSetDetailImageMapper;
import com.bzh.business.mapper.BzhStoreMapper;
import com.bzh.common.constant.Constants;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhProductSetMapper;
import com.bzh.business.domain.BzhProductSet;
import com.bzh.business.service.IBzhProductSetService;

/**
 * 商品套装Service业务层处理
 *
 * @author bzh
 * @date 2025-03-31
 */
@Service
public class BzhProductSetServiceImpl implements IBzhProductSetService
{
    @Autowired
    private BzhProductSetMapper bzhProductSetMapper;
    @Autowired
    private BzhStoreMapper bzhStoreMapper;
    @Autowired
    private BzhProductSetDetailImageMapper bzhProductSetDetailImageMapper;


    /**
     * 查询商品套装
     *
     * @param id 商品套装主键
     * @return 商品套装
     */
    @Override
    public BzhProductSet selectBzhProductSetById(Long id)
    {
        return bzhProductSetMapper.selectBzhProductSetById(id);
    }

    /**
     * 查询商品套装列表
     *
     * @param bzhProductSet 商品套装
     * @return 商品套装
     */
    @Override
    public List<BzhProductSet> selectBzhProductSetList(BzhProductSet bzhProductSet)
    {
        List<BzhProductSet> list = bzhProductSetMapper.selectBzhProductSetList(bzhProductSet);
        List<BzhStore> bzhStores = bzhStoreMapper.selectBzhStoreList(new BzhStore());
        Map<Long, BzhStore> mapBzhStore = bzhStores.stream().collect(Collectors.toMap(BzhStore::getId, Function.identity()));
        list.forEach(item -> {
            item.setStoreName(mapBzhStore.get(item.getStoreId()).getStoreName());
        });
        return list;
    }

    /**
     * 新增商品套装
     *
     * @param bzhProductSet 商品套装
     * @return 结果
     */
    @Override
    public int insertBzhProductSet(BzhProductSet bzhProductSet)
    {
        bzhProductSet.setCreateTime(DateUtils.getNowDate());
        return bzhProductSetMapper.insertBzhProductSet(bzhProductSet);
    }

    /**
     * 修改商品套装
     *
     * @param bzhProductSet 商品套装
     * @return 结果
     */
    @Override
    public int updateBzhProductSet(BzhProductSet bzhProductSet)
    {
        bzhProductSet.setUpdateTime(DateUtils.getNowDate());
        return bzhProductSetMapper.updateBzhProductSet(bzhProductSet);
    }

    /**
     * 批量删除商品套装
     *
     * @param ids 需要删除的商品套装主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetByIds(Long[] ids)
    {
        return bzhProductSetMapper.deleteBzhProductSetByIds(ids);
    }

    /**
     * 删除商品套装信息
     *
     * @param id 商品套装主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductSetById(Long id)
    {
        return bzhProductSetMapper.deleteBzhProductSetById(id);
    }

    @Override
    public List<BzhProductSet> selectList(BzhProductSet bzhProductSet) {
        return bzhProductSetMapper.selectBzhProductSetList(bzhProductSet);
    }

    @Override
    public BzhProductSet getProductSetBySetId(Long productSetId) {
        BzhProductSet bzhProductSet = bzhProductSetMapper.selectBzhProductSetById(productSetId);
        bzhProductSet.setProductList(bzhProductSetMapper.selectBzhProductBySetId(productSetId));
        BzhProductSetDetailImage bzhProductSetDetailImage = new BzhProductSetDetailImage();
        bzhProductSetDetailImage.setProductSetId(productSetId);
        bzhProductSetDetailImage.setStatus(Constants.STATUS_YES);
        List<BzhProductSetDetailImage> bzhProductSetDetailImages = bzhProductSetDetailImageMapper.selectBzhProductSetDetailImageList(bzhProductSetDetailImage);
        bzhProductSet.setProductSetDetailImages(bzhProductSetDetailImages);
        return bzhProductSet;
    }
}
