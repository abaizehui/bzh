package com.bzh.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * 商品对象 bzh_product
 * 
 * @author bzh
 * @date 2025-01-04
 */
public class BzhProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 所属类目ID */
    @Excel(name = "所属类目ID")
    private Long categoryId;

    /** 门店ID */
    @Excel(name = "门店ID")
    private Long storeId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 是否首页推荐1：推，0：不推 */
    @Excel(name = "是否首页推荐1：推，0：不推")
    private Long isRecommend;

    /** 是否启用状态1：启用，0：停用 */
    @Excel(name = "是否启用状态1：启用，0：停用")
    private Long isActive;

    /** 商品图片URL */
    @Excel(name = "商品图片URL")
    private String imageUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setIsRecommend(Long isRecommend) 
    {
        this.isRecommend = isRecommend;
    }

    public Long getIsRecommend() 
    {
        return isRecommend;
    }
    public void setIsActive(Long isActive) 
    {
        this.isActive = isActive;
    }

    public Long getIsActive() 
    {
        return isActive;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("storeId", getStoreId())
            .append("name", getName())
            .append("price", getPrice())
            .append("isRecommend", getIsRecommend())
            .append("isActive", getIsActive())
            .append("imageUrl", getImageUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
