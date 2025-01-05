package com.bzh.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bzh.common.annotation.Log;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.common.enums.BusinessType;
import com.bzh.business.domain.BzhProductSku;
import com.bzh.business.service.IBzhProductSkuService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * SKUController
 * 
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/sku")
public class BzhProductSkuController extends BaseController
{
    @Autowired
    private IBzhProductSkuService bzhProductSkuService;

    /**
     * 查询SKU列表
     */
    @PreAuthorize("@ss.hasPermi('business:sku:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhProductSku bzhProductSku)
    {
        startPage();
        List<BzhProductSku> list = bzhProductSkuService.selectBzhProductSkuList(bzhProductSku);
        return getDataTable(list);
    }

    /**
     * 导出SKU列表
     */
    @PreAuthorize("@ss.hasPermi('business:sku:export')")
    @Log(title = "SKU", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductSku bzhProductSku)
    {
        List<BzhProductSku> list = bzhProductSkuService.selectBzhProductSkuList(bzhProductSku);
        ExcelUtil<BzhProductSku> util = new ExcelUtil<BzhProductSku>(BzhProductSku.class);
        util.exportExcel(response, list, "SKU数据");
    }

    /**
     * 获取SKU详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:sku:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductSkuService.selectBzhProductSkuById(id));
    }

    /**
     * 新增SKU
     */
    @PreAuthorize("@ss.hasPermi('business:sku:add')")
    @Log(title = "SKU", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductSku bzhProductSku)
    {
        return toAjax(bzhProductSkuService.insertBzhProductSku(bzhProductSku));
    }

    /**
     * 修改SKU
     */
    @PreAuthorize("@ss.hasPermi('business:sku:edit')")
    @Log(title = "SKU", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductSku bzhProductSku)
    {
        return toAjax(bzhProductSkuService.updateBzhProductSku(bzhProductSku));
    }

    /**
     * 删除SKU
     */
    @PreAuthorize("@ss.hasPermi('business:sku:remove')")
    @Log(title = "SKU", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductSkuService.deleteBzhProductSkuByIds(ids));
    }
}
