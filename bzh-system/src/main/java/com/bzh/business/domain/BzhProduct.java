package com.bzh.business.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 商品对象 bzh_product
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 门店ID */
    private Long storeId;

    @Excel(name = "门店")
    private String storeName;

    /** 产品类目ID */
    private Long categoryId;

    @Excel(name = "产品类目")
    private String categoryName;


    @Excel(name = "商品名称")
    private String productName;


    @Excel(name = "商品描述")
    private String productDescribe;


    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal productPrice;

    /** 商品图片 */
    private String imageUrl;

    /** 商品视频介绍 */
    private String videoUrl;

    @Excel(name = "首页是否推荐", readConverterExp = "0=推荐,1=不推荐")
    private String recommend;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 排序顺序 */
    @Excel(name = "排序顺序")
    private Long sortOrder;

    private String sortColumn;

    private String priceSort;

    private List<BzhProductParam>  productParamList;

    private List<BzhProductConfig>  productConfigList;

    private List<BzhProductDetailImage>  productDetailImages;

    private List<Long> ids;

}
