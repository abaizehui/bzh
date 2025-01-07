package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 轮播图对象 bzh_carousel_images
 *
 * @author bzh
 * @date 2025-01-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhCarouselImages extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 门店ID */
    private Long storeId;

    private String storeName;

    /** 图片 */
    private String imageUrl;

    /** 排序顺序 */
    private Long sortOrder;

    /** 是否启用状态1：启用，2：停用 */
    private String status;

}
