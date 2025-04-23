package com.bzh.business.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bzh.business.domain.BzhWechatUser;
import com.bzh.business.req.BzhQrCodeReq;
import com.bzh.business.service.IBzhWechatUserService;
import com.bzh.business.service.IBzhWxApiService;
import com.bzh.common.config.BzhConfig;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.redis.RedisCache;
import com.bzh.common.utils.AliYunOSSUtils;
import com.bzh.common.utils.file.FileUploadUtils;
import com.bzh.common.utils.http.HttpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


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

    @Value("${wx.api.qrCodeUrl}")
    private String qrCodeUrl;
    @Autowired
    private AliYunOSSUtils aliYunOSSUtils;

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

    @Override
    public String getQrCode(BzhQrCodeReq bzhQrCodeReq) {

        BzhWechatUser bzhWechatUser = bzhWechatUserService.selectBzhWechatUserById(bzhQrCodeReq.getUserId());
        if (Objects.isNull(bzhWechatUser)) {
            throw new RuntimeException("未登陆，获取二维码失败");
        }
        if (StringUtils.isNotBlank(bzhWechatUser.getQrCodeUrl())) {
            return bzhWechatUser.getQrCodeUrl();
        }

        String accessToken = getAccessToken();
        String getQrcode = qrCodeUrl + "?access_token=" + accessToken;
        String param = "{\"page\":\""+bzhQrCodeReq.getPage()+"\",\"scene\":\""+bzhQrCodeReq.getScene()+"\",\"check_path\":true,\"env_version\":\""+bzhQrCodeReq.getEnvVersion()+"\"}";
        byte[] bytes = HttpUtils.sendPostByte(getQrcode, param);
        try {
            String qrCodePath = BzhConfig.getQrCodePath();
            String qrCodeName = System.currentTimeMillis() + ".jpg";
            String pathFileName = aliYunOSSUtils.uploadByte(bytes, qrCodePath + "/" + qrCodeName);

            BzhWechatUser user = new BzhWechatUser();
            user.setId(bzhWechatUser.getId());
            user.setQrCodeUrl(pathFileName);
            bzhWechatUserService.updateBzhWechatUser(user);
            return pathFileName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getAccessToken() {
        String param = "{\"grant_type\":\"client_credential\",\"appid\":\""+ appId + "\",\"secret\":\""+ appSecret +"\"}";
        String result = HttpUtils.sendPost(tokenUrl,param);
        JSONObject obj = JSON.parseObject(result);
        String token = obj.getString("access_token");
        if (Objects.isNull(token)) {
            throw new RuntimeException("获取accessToken失败");
        }
        return token;
    }



}
