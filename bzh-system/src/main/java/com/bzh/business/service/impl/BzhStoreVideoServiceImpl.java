package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhStoreVideoMapper;
import com.bzh.business.domain.BzhStoreVideo;
import com.bzh.business.service.IBzhStoreVideoService;

/**
 * 门店视频Service业务层处理
 *
 * @author bzh
 * @date 2025-04-23
 */
@Service
public class BzhStoreVideoServiceImpl implements IBzhStoreVideoService
{
    @Autowired
    private BzhStoreVideoMapper bzhStoreVideoMapper;

    /**
     * 查询门店视频
     *
     * @param id 门店视频主键
     * @return 门店视频
     */
    @Override
    public BzhStoreVideo selectBzhStoreVideoById(Long id)
    {
        return bzhStoreVideoMapper.selectBzhStoreVideoById(id);
    }

    /**
     * 查询门店视频列表
     *
     * @param bzhStoreVideo 门店视频
     * @return 门店视频
     */
    @Override
    public List<BzhStoreVideo> selectBzhStoreVideoList(BzhStoreVideo bzhStoreVideo)
    {
        return bzhStoreVideoMapper.selectBzhStoreVideoList(bzhStoreVideo);
    }

    /**
     * 新增门店视频
     *
     * @param bzhStoreVideo 门店视频
     * @return 结果
     */
    @Override
    public int insertBzhStoreVideo(BzhStoreVideo bzhStoreVideo)
    {
        bzhStoreVideo.setCreateTime(DateUtils.getNowDate());
        return bzhStoreVideoMapper.insertBzhStoreVideo(bzhStoreVideo);
    }

    /**
     * 修改门店视频
     *
     * @param bzhStoreVideo 门店视频
     * @return 结果
     */
    @Override
    public int updateBzhStoreVideo(BzhStoreVideo bzhStoreVideo)
    {
        bzhStoreVideo.setUpdateTime(DateUtils.getNowDate());
        return bzhStoreVideoMapper.updateBzhStoreVideo(bzhStoreVideo);
    }

    /**
     * 批量删除门店视频
     *
     * @param ids 需要删除的门店视频主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreVideoByIds(Long[] ids)
    {
        return bzhStoreVideoMapper.deleteBzhStoreVideoByIds(ids);
    }

    /**
     * 删除门店视频信息
     *
     * @param id 门店视频主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreVideoById(Long id)
    {
        return bzhStoreVideoMapper.deleteBzhStoreVideoById(id);
    }

    @Override
    public void updateStoreVideoPlayById(Long storeVideoId) {
        bzhStoreVideoMapper.updateStoreVideoPlayById(storeVideoId);
    }
}
