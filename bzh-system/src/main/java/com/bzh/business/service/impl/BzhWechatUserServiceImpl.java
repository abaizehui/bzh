package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhWechatUserMapper;
import com.bzh.business.domain.BzhWechatUser;
import com.bzh.business.service.IBzhWechatUserService;

/**
 * 微信用户Service业务层处理
 *
 * @author bzh
 * @date 2025-03-23
 */
@Service
public class BzhWechatUserServiceImpl implements IBzhWechatUserService
{
    @Autowired
    private BzhWechatUserMapper bzhWechatUserMapper;

    /**
     * 查询微信用户
     *
     * @param id 微信用户主键
     * @return 微信用户
     */
    @Override
    public BzhWechatUser selectBzhWechatUserById(Long id)
    {
        return bzhWechatUserMapper.selectBzhWechatUserById(id);
    }

    /**
     * 查询微信用户列表
     *
     * @param bzhWechatUser 微信用户
     * @return 微信用户
     */
    @Override
    public List<BzhWechatUser> selectBzhWechatUserList(BzhWechatUser bzhWechatUser)
    {
        return bzhWechatUserMapper.selectBzhWechatUserList(bzhWechatUser);
    }

    /**
     * 新增微信用户
     *
     * @param bzhWechatUser 微信用户
     * @return 结果
     */
    @Override
    public int insertBzhWechatUser(BzhWechatUser bzhWechatUser)
    {
        bzhWechatUser.setCreateTime(DateUtils.getNowDate());
        return bzhWechatUserMapper.insertBzhWechatUser(bzhWechatUser);
    }

    /**
     * 修改微信用户
     *
     * @param bzhWechatUser 微信用户
     * @return 结果
     */
    @Override
    public int updateBzhWechatUser(BzhWechatUser bzhWechatUser)
    {
        bzhWechatUser.setUpdateTime(DateUtils.getNowDate());
        return bzhWechatUserMapper.updateBzhWechatUser(bzhWechatUser);
    }

    /**
     * 批量删除微信用户
     *
     * @param ids 需要删除的微信用户主键
     * @return 结果
     */
    @Override
    public int deleteBzhWechatUserByIds(Long[] ids)
    {
        return bzhWechatUserMapper.deleteBzhWechatUserByIds(ids);
    }

    /**
     * 删除微信用户信息
     *
     * @param id 微信用户主键
     * @return 结果
     */
    @Override
    public int deleteBzhWechatUserById(Long id)
    {
        return bzhWechatUserMapper.deleteBzhWechatUserById(id);
    }

    @Override
    public BzhWechatUser selectBzhWechatUserByOpenId(String openId) {
        return bzhWechatUserMapper.selectBzhWechatUserByOpenId(openId);
    }
}
