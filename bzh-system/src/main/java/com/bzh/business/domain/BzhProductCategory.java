package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 产品类目对象 bzh_product_category
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 门店ID */
    private Long storeId;

    /** 门店名称 */
    @Excel(name = "门店名称")
    private String storeName;

    /** 类目名称 */
    @Excel(name = "类目名称")
    private String categoryName;

    /** 类目图标URL */
    @Excel(name = "图标")
    private String imageUrl;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 排序顺序 */
    @Excel(name = "排序顺序")
    private Long sortOrder;
}
