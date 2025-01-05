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
import com.bzh.business.domain.BzhProduct;
import com.bzh.business.service.IBzhProductService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/product")
public class BzhProductController extends BaseController
{
    @Autowired
    private IBzhProductService bzhProductService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('business:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhProduct bzhProduct)
    {
        startPage();
        List<BzhProduct> list = bzhProductService.selectBzhProductList(bzhProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('business:product:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProduct bzhProduct)
    {
        List<BzhProduct> list = bzhProductService.selectBzhProductList(bzhProduct);
        ExcelUtil<BzhProduct> util = new ExcelUtil<BzhProduct>(BzhProduct.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductService.selectBzhProductById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('business:product:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhProduct bzhProduct)
    {
        return toAjax(bzhProductService.insertBzhProduct(bzhProduct));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('business:product:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProduct bzhProduct)
    {
        return toAjax(bzhProductService.updateBzhProduct(bzhProduct));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('business:product:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductService.deleteBzhProductByIds(ids));
    }
}
