package com.bzh.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bzh.common.annotation.Excel;
import com.bzh.common.core.domain.BaseEntity;

/**
 * SKU对象 bzh_product_sku
 * 
 * @author bzh
 * @date 2025-01-04
 */
public class BzhProductSku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 商品ID */
    private Long productId;

    /** 变种描述（如颜色、尺寸等） */
    @Excel(name = "变种描述", readConverterExp = "如=颜色、尺寸等")
    private String variant;

    /** SKU价格 */
    @Excel(name = "SKU价格")
    private BigDecimal price;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stockQuantity;

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
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setVariant(String variant) 
    {
        this.variant = variant;
    }

    public String getVariant() 
    {
        return variant;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setStockQuantity(Long stockQuantity) 
    {
        this.stockQuantity = stockQuantity;
    }

    public Long getStockQuantity() 
    {
        return stockQuantity;
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
            .append("productId", getProductId())
            .append("variant", getVariant())
            .append("price", getPrice())
            .append("stockQuantity", getStockQuantity())
            .append("isActive", getIsActive())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
