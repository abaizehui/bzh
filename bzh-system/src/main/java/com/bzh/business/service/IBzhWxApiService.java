package com.bzh.business.service;


import com.bzh.business.domain.BzhWechatUser;
import com.bzh.business.req.BzhQrCodeReq;

import java.io.IOException;

/**
 * 分享Service接口
 *
 * @author bzh
 * @date 2025-01-04
 */
public interface IBzhWxApiService
{

    String getPhoneNumber(String code);

    BzhWechatUser login(String code, String phoneNumber);

    String getQrCode(BzhQrCodeReq bzhQrCodeReq);
}
