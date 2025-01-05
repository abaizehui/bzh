package com.bzh.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 产品类目对象 bzh_product_category
 * 
 * @author bzh
 * @date 2025-01-04
 */
public class BzhProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 类目名称 */
    @Excel(name = "类目名称")
    private String name;

    /** 父类目ID */
    @Excel(name = "父类目ID")
    private Long parentId;

    /** 类目层级 */
    @Excel(name = "类目层级")
    private Integer level;

    /** 排序顺序 */
    @Excel(name = "排序顺序")
    private Long sortOrder;

    /** 类目图标URL */
    @Excel(name = "类目图标URL")
    private String imageUrl;

    /** 是否启用状态1：启用，0：停用 */
    @Excel(name = "是否启用状态1：启用，0：停用")
    private Long isActive;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setIsActive(Long isActive) 
    {
        this.isActive = isActive;
    }

    public Long getIsActive() 
    {
        return isActive;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("parentId", getParentId())
            .append("level", getLevel())
            .append("sortOrder", getSortOrder())
            .append("imageUrl", getImageUrl())
            .append("isActive", getIsActive())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
