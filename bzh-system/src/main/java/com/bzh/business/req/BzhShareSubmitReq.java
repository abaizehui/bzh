package com.bzh.business.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 预约提交
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhShareSubmitReq
{

    private Long storeId;
    private String name;
    private String phone;
    private Long productId;
    private Long inviterUserId;
    private Long productSetId;

}
