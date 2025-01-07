package com.bzh.business.domain;

import lombok.Data;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 门店对象 bzh_store
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
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
    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

}
