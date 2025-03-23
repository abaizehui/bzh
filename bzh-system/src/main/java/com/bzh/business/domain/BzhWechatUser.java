package com.bzh.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BzhWechatUser extends BaseEntity
{

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

    /** 个人二维码 */
    private String qrCodeUrl;
}
