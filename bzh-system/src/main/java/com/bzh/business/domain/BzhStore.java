package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;
import lombok.NoArgsConstructor;

/**
 * 门店对象 bzh_store
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhStore extends BaseEntity
{

    /** 主键 */
    private Long id;

    /** 门店名称 */
    @Excel(name = "门店名称")
    private String storeName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;
    /** 图片URL */
    private String imageUrl;
    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;
    @Excel(name = "营业时间")
    private String businessHours;
    @Excel(name = "小程序id")
    private String appId;
    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;


}
