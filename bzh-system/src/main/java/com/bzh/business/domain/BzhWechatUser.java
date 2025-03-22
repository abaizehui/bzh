package com.bzh.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 微信用户对象 bzh_wechat_user
 * 
 * @author bzh
 * @date 2025-03-23
 */
public class BzhWechatUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户唯一标识，自增主键 */
    private Long id;

    /** 微信用户唯一标识 */
    @Excel(name = "微信用户唯一标识")
    private String openId;

    /** 微信开放平台统一标识，用于关联多个应用的同一用户 */
    @Excel(name = "微信开放平台统一标识，用于关联多个应用的同一用户")
    private String unionId;

    /** 用户微信昵称 */
    @Excel(name = "用户微信昵称")
    private String nickName;

    /** 用户微信头像链接 */
    @Excel(name = "用户微信头像链接")
    private String avatarUrl;

    /** 用户性别：0-未知，1-男性，2-女性 */
    @Excel(name = "用户性别：0-未知，1-男性，2-女性")
    private Integer gender;

    /** 用户所在国家 */
    @Excel(name = "用户所在国家")
    private String country;

    /** 用户所在省份 */
    @Excel(name = "用户所在省份")
    private String province;

    /** 用户所在城市 */
    @Excel(name = "用户所在城市")
    private String city;

    /** 用户微信语言设置 */
    @Excel(name = "用户微信语言设置")
    private String language;

    /** 用户绑定的手机号码 */
    @Excel(name = "用户绑定的手机号码")
    private String phoneNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setUnionId(String unionId) 
    {
        this.unionId = unionId;
    }

    public String getUnionId() 
    {
        return unionId;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public String getLanguage() 
    {
        return language;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openId", getOpenId())
            .append("unionId", getUnionId())
            .append("nickName", getNickName())
            .append("avatarUrl", getAvatarUrl())
            .append("gender", getGender())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("language", getLanguage())
            .append("phoneNumber", getPhoneNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
