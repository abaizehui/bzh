package com.bzh.business.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bzh.business.domain.*;
import com.bzh.business.mapper.*;
import com.bzh.common.constant.Constants;
import com.bzh.common.utils.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.service.IBzhProductService;

/**
 * 商品Service业务层处理
 *
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhProductServiceImpl implements IBzhProductService
{
    @Autowired
    private BzhProductMapper bzhProductMapper;
    @Autowired
    private BzhStoreMapper bzhStoreMapper;
    @Autowired
    private BzhProductCategoryMapper bzhProductCategoryMapper;

    @Autowired
    private BzhProductDetailImageMapper bzhProductDetailImageMapper;

    @Autowired
    private BzhProductParamMapper bzhProductParamMapper;

    @Autowired
    private BzhProductConfigMapper bzhProductConfigMapper;

    @Autowired
    private BzhProductSceneImageMapper bzhProductSceneImageMapper;

    @Autowired
    private BzhStoreReservationMapper bzhStoreReservationMapper;
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public BzhProduct selectBzhProductById(Long id)
    {
        return bzhProductMapper.selectBzhProductById(id);
    }

    /**
     * 查询商品列表
     *
     * @param bzhProduct 商品
     * @return 商品
     */
    @Override
    public List<BzhProduct> selectBzhProductList(BzhProduct bzhProduct)
    {
        List<BzhProduct> list = bzhProductMapper.selectBzhProductList(bzhProduct);
        List<BzhStore> bzhStores = bzhStoreMapper.selectBzhStoreList(new BzhStore());
        Map<Long, BzhStore> mapBzhStore = bzhStores.stream().collect(Collectors.toMap(BzhStore::getId, Function.identity()));
        List<BzhProductCategory> bzhProductCategories = bzhProductCategoryMapper.selectBzhProductCategoryList(new BzhProductCategory());
        Map<Long, BzhProductCategory> mapBzhProductCategory = bzhProductCategories.stream().collect(Collectors.toMap(BzhProductCategory::getId, Function.identity()));

        list.forEach(item -> {
            item.setStoreName(mapBzhStore.get(item.getStoreId()).getStoreName());
            item.setCategoryName(mapBzhProductCategory.get(item.getCategoryId()).getCategoryName());
        });
        return list;
    }

    /**
     * 查询商品列表
     *
     * @param bzhProduct 商品
     * @return 商品
     */
    @Override
    public List<BzhProduct> selectList(BzhProduct bzhProduct)
    {
        return bzhProductMapper.selectBzhProductList(bzhProduct);
    }


    /**
     * 新增商品
     *
     * @param bzhProduct 商品
     * @return 结果
     */
    @Override
    public int insertBzhProduct(BzhProduct bzhProduct)
    {
        bzhProduct.setCreateTime(DateUtils.getNowDate());
        return bzhProductMapper.insertBzhProduct(bzhProduct);
    }

    /**
     * 修改商品
     *
     * @param bzhProduct 商品
     * @return 结果
     */
    @Override
    public int updateBzhProduct(BzhProduct bzhProduct)
    {
        bzhProduct.setUpdateTime(DateUtils.getNowDate());
        return bzhProductMapper.updateBzhProduct(bzhProduct);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductByIds(Long[] ids)
    {
        return bzhProductMapper.deleteBzhProductByIds(ids);
    }

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteBzhProductById(Long id)
    {
        return bzhProductMapper.deleteBzhProductById(id);
    }

    @Override
    public BzhProduct getProductDetailByProductId(Long productId) {
        BzhProduct bzhProduct = bzhProductMapper.selectBzhProductById(productId);
        if (Objects.isNull(bzhProduct)) {
            return null;
        }
        BzhProductParam bzhProductParam = new BzhProductParam();
        bzhProductParam.setProductId(productId);
        bzhProductParam.setStatus(Constants.STATUS_YES);
        List<BzhProductParam> bzhProductParams = bzhProductParamMapper.selectBzhProductParamList(bzhProductParam);
        if (CollectionUtils.isNotEmpty(bzhProductParams)) {
            bzhProduct.setProductParamList(bzhProductParams);
        }

        BzhProductConfig bzhProductConfig = new BzhProductConfig();
        bzhProductConfig.setProductId(productId);
        bzhProductConfig.setStatus(Constants.STATUS_YES);
        List<BzhProductConfig> bzhProductConfigs = bzhProductConfigMapper.selectBzhProductConfigList(bzhProductConfig);
        if (CollectionUtils.isNotEmpty(bzhProductConfigs)) {
            bzhProduct.setProductConfigList(bzhProductConfigs);
        }

        BzhProductDetailImage bzhProductDetailImage = new BzhProductDetailImage();
        bzhProductDetailImage.setProductId(productId);
        bzhProductDetailImage.setStatus(Constants.STATUS_YES);
        List<BzhProductDetailImage> bzhProductDetailImages = bzhProductDetailImageMapper.selectBzhProductDetailImageList(bzhProductDetailImage);
        if (CollectionUtils.isNotEmpty(bzhProductDetailImages)) {
            bzhProduct.setProductDetailImages(bzhProductDetailImages);
        }
        return bzhProduct;
    }

    @Override
    public List<BzhProduct> getProductListByPhoneNumber(String phoneNumber) {
        BzhStoreReservation bzhStoreReservation = new BzhStoreReservation();
        bzhStoreReservation.setPhone(phoneNumber);
        List<BzhStoreReservation> bzhStoreReservations = bzhStoreReservationMapper.selectBzhStoreReservationList(bzhStoreReservation);
        List<Long> ids = bzhStoreReservations.stream().map(BzhStoreReservation::getProductId).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        BzhProduct bzhProduct = new BzhProduct();
        bzhProduct.setIds(ids);
        bzhProduct.setStatus(Constants.STATUS_YES);
        return bzhProductMapper.selectBzhProductList(bzhProduct);
    }
}
