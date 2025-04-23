package com.bzh.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 门店视频对象 bzh_store_video
 * 
 * @author bzh
 * @date 2025-04-23
 */
public class BzhStoreVideo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 门店ID */
    @Excel(name = "门店ID")
    private Long storeId;

    /** 图片url */
    @Excel(name = "图片url")
    private String imageUrl;

    /** 视频url */
    @Excel(name = "视频url")
    private String videoUrl;

    /** 视频描述 */
    @Excel(name = "视频描述")
    private String videoDescribe;

    /** 视频播放数量 */
    @Excel(name = "视频播放数量")
    private Long videoPlay;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 排序 */
    @Excel(name = "排序")
    private Long sortOrder;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setVideoUrl(String videoUrl) 
    {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() 
    {
        return videoUrl;
    }
    public void setVideoDescribe(String videoDescribe) 
    {
        this.videoDescribe = videoDescribe;
    }

    public String getVideoDescribe() 
    {
        return videoDescribe;
    }
    public void setVideoPlay(Long videoPlay) 
    {
        this.videoPlay = videoPlay;
    }

    public Long getVideoPlay() 
    {
        return videoPlay;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storeId", getStoreId())
            .append("imageUrl", getImageUrl())
            .append("videoUrl", getVideoUrl())
            .append("videoDescribe", getVideoDescribe())
            .append("videoPlay", getVideoPlay())
            .append("status", getStatus())
            .append("sortOrder", getSortOrder())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
