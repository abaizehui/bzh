package com.bzh.business.domain;

import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 门店预约参数对象 bzh_store_reservation
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhStoreReservation extends BaseEntity
{
    /** 主键 */
    private Long id;

    /** 门店ID */
    private Long storeId;

    /** 商品ID */
    private Long productId;

    /** 套装ID */
    private Long setId;

    /** 姓名 */
    @Excel(name = "产品名称")
    private String productName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 姓名 */
    @Excel(name = "邀请人")
    private Long inviterUserId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date createTime;

}
