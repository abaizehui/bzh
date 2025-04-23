package com.bzh.business.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小程序二维码
 *
 * @author bzh
 * @date 2025-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhQrCodeReq
{

    /**
     * 页面路径
     */
    private String page;

    /**
     * 传递的参数
     */
    private String scene;

    /**
     * 要打开的小程序版本。正式版为 "release"，体验版为 "trial"，开发版为 "develop"
     */
    private String envVersion;


    /**
     * userId
     */
    private Long userId;

}
