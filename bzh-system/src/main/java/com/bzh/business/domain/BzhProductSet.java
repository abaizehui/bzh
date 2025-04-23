package com.bzh.business.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 商品套装对象 bzh_product_set
 *
 * @author bzh
 * @date 2025-03-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhProductSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 门店ID */
    private Long storeId;

    @Excel(name = "门店")
    private String storeName;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String productDescribe;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal productPrice;

    /** 首页图片 */
    @Excel(name = "首页图片")
    private String imageUrl;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 排序 */
    @Excel(name = "排序")
    private Long sortOrder;

    private List<BzhProduct> productList;

    private List<BzhProductSetDetailImage> productSetDetailImages;


}
