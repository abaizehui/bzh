package com.bzh.business.service;

import java.util.List;
import com.bzh.business.domain.BzhStoreVideo;

/**
 * 门店视频Service接口
 *
 * @author bzh
 * @date 2025-04-23
 */
public interface IBzhStoreVideoService
{
    /**
     * 查询门店视频
     *
     * @param id 门店视频主键
     * @return 门店视频
     */
    public BzhStoreVideo selectBzhStoreVideoById(Long id);

    /**
     * 查询门店视频列表
     *
     * @param bzhStoreVideo 门店视频
     * @return 门店视频集合
     */
    public List<BzhStoreVideo> selectBzhStoreVideoList(BzhStoreVideo bzhStoreVideo);

    /**
     * 新增门店视频
     *
     * @param bzhStoreVideo 门店视频
     * @return 结果
     */
    public int insertBzhStoreVideo(BzhStoreVideo bzhStoreVideo);

    /**
     * 修改门店视频
     *
     * @param bzhStoreVideo 门店视频
     * @return 结果
     */
    public int updateBzhStoreVideo(BzhStoreVideo bzhStoreVideo);

    /**
     * 批量删除门店视频
     *
     * @param ids 需要删除的门店视频主键集合
     * @return 结果
     */
    public int deleteBzhStoreVideoByIds(Long[] ids);

    /**
     * 删除门店视频信息
     *
     * @param id 门店视频主键
     * @return 结果
     */
    public int deleteBzhStoreVideoById(Long id);

    void updateStoreVideoPlayById(Long storeVideoId);
}
