package com.bzh.business.domain;

import com.bzh.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    /** 商品ID */
    private Long productId;

    /** 姓名 */
    private String name;

    /** 手机号 */
    private String phone;

}
