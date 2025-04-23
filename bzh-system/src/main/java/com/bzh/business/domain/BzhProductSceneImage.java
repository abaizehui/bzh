package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 商品实景图对象 bzh_product_scene_image
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhProductSceneImage extends BaseEntity
{

    /** 主键 */
    private Long id;

    /** 商品ID */
    private Long productId;

    /** 图片URL */
    private String imageUrl;

    /** 状态（0正常 1停用） */
    private String status;

    /** 排序顺序 */
    private Long sortOrder;

}
