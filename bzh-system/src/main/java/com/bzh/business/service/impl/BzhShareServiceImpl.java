package com.bzh.business.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bzh.business.service.IBzhShareService;
import com.bzh.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 分享Service业务层处理
 *
 * @author bzh
 * @date 2025-01-04
 */
@Service
public class BzhShareServiceImpl implements IBzhShareService
{

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Value("${wx.api.tokenUrl}")
    private String tokenUrl;

    @Value("${wx.api.phoneNumberUrl}")
    private String phoneNumberUrl;

    @Override
    public String getPhoneNumber(String code) {
        String accessToken = getAccessToken();
        if (Objects.isNull(accessToken)) {
            throw new RuntimeException("accessToken获取失败");
        }
        String url = phoneNumberUrl + "?access_token=" + accessToken;
        String param = "{\"code\":\""+ code +"\"}";
        String result = HttpUtils.sendPost(url, param);
        JSONObject obj = JSON.parseObject(result);
        String phoneInfo = obj.getString("phone_info");
        if (Objects.isNull(phoneInfo)) {
            throw new RuntimeException("phoneInfo获取手机号失败");
        }
        JSONObject phoneInfoObj = JSON.parseObject(phoneInfo);
        return phoneInfoObj.getString("phoneNumber");
    }

    private String getAccessToken() {
        String param = "{\"grant_type\":\"client_credential\",\"appid\":\""+ appId + "\",\"secret\":\""+ appSecret +"\"}";
        String result = HttpUtils.sendPost(tokenUrl,param);
        JSONObject obj = JSON.parseObject(result);
        return obj.getString("access_token");
    }



}
