package com.bzh.business.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bzh.business.domain.BzhWechatUser;
import com.bzh.business.service.IBzhWechatUserService;
import com.bzh.business.service.IBzhWxApiService;
import com.bzh.common.constant.Constants;
import com.bzh.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BzhWxApiServiceImpl implements IBzhWxApiService
{

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Value("${wx.api.tokenUrl}")
    private String tokenUrl;

    @Value("${wx.api.phoneNumberUrl}")
    private String phoneNumberUrl;

    @Value("${wx.api.loginUrl}")
    private String loginUrl;

    @Autowired
    private IBzhWechatUserService bzhWechatUserService;

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

    @Override
    public BzhWechatUser login(String code, String phoneNumber) {
        String param = "appid="+appId+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code" ;
        String result = HttpUtils.sendGet(loginUrl, param, Constants.UTF8);
        JSONObject obj = JSON.parseObject(result);
        String openId = obj.getString("openid");
        if (Objects.isNull(openId)) {
            throw new RuntimeException("openid获取失败");
        }
        String unionId = obj.getString("unionid");
        BzhWechatUser bzhWechatUser = bzhWechatUserService.selectBzhWechatUserByOpenId(openId);
        if (Objects.nonNull(bzhWechatUser)) {
            return bzhWechatUser;
        }
        BzhWechatUser newBzhWechatUser = new BzhWechatUser();
        newBzhWechatUser.setOpenId(openId);
        newBzhWechatUser.setUnionId(unionId);
        newBzhWechatUser.setPhoneNumber(phoneNumber);
        bzhWechatUserService.insertBzhWechatUser(newBzhWechatUser);
        return newBzhWechatUser;
    }

    private String getAccessToken() {
        String param = "{\"grant_type\":\"client_credential\",\"appid\":\""+ appId + "\",\"secret\":\""+ appSecret +"\"}";
        String result = HttpUtils.sendPost(tokenUrl,param);
        JSONObject obj = JSON.parseObject(result);
        return obj.getString("access_token");
    }



}
