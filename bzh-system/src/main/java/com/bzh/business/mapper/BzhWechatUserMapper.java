package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhWechatUser;

/**
 * 微信用户Mapper接口
 *
 * @author bzh
 * @date 2025-03-23
 */
public interface BzhWechatUserMapper
{
    /**
     * 查询微信用户
     *
     * @param id 微信用户主键
     * @return 微信用户
     */
    public BzhWechatUser selectBzhWechatUserById(Long id);

    /**
     * 查询微信用户列表
     *
     * @param bzhWechatUser 微信用户
     * @return 微信用户集合
     */
    public List<BzhWechatUser> selectBzhWechatUserList(BzhWechatUser bzhWechatUser);

    /**
     * 新增微信用户
     *
     * @param bzhWechatUser 微信用户
     * @return 结果
     */
    public int insertBzhWechatUser(BzhWechatUser bzhWechatUser);

    /**
     * 修改微信用户
     *
     * @param bzhWechatUser 微信用户
     * @return 结果
     */
    public int updateBzhWechatUser(BzhWechatUser bzhWechatUser);

    /**
     * 删除微信用户
     *
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteBzhWechatUserById(Long id);

    /**
     * 批量删除微信用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhWechatUserByIds(Long[] ids);

    BzhWechatUser selectBzhWechatUserByOpenId(String openId);
}
