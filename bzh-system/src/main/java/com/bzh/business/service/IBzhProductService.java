package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhProduct;

/**
 * 商品Service接口
 *
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhProductService
{
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public BzhProduct selectBzhProductById(Long id);

    /**
     * 查询商品列表
     *
     * @param bzhProduct 商品
     * @return 商品集合
     */
    public List<BzhProduct> selectBzhProductList(BzhProduct bzhProduct);

    /**
     * 查询商品列表
     *
     * @param bzhProduct 商品
     * @return 商品集合
     */
    public List<BzhProduct> selectList(BzhProduct bzhProduct);

    /**
     * 新增商品
     *
     * @param bzhProduct 商品
     * @return 结果
     */
    public int insertBzhProduct(BzhProduct bzhProduct);

    /**
     * 修改商品
     *
     * @param bzhProduct 商品
     * @return 结果
     */
    public int updateBzhProduct(BzhProduct bzhProduct);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteBzhProductByIds(Long[] ids);

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteBzhProductById(Long id);

    public BzhProduct getProductDetailByProductId(Long productId);

    public List<BzhProduct> getProductListByPhoneNumber(String phoneNumber);
}
