package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 商品参数对象 bzh_product_param
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhProductParam extends BaseEntity
{
    /** 主键 */
    private Long id;

    /** 商品ID */
    private Long productId;

    /** 参数名称 */
    private String paramName;

    /** 参数值 */
    private String paramValue;

    /** 状态（0正常 1停用） */
    private String status;

    /** 排序顺序 */
    private Long sortOrder;
}
