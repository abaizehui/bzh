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
import com.bzh.business.domain.BzhProductCategory;
import com.bzh.business.service.IBzhProductCategoryService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 产品类目Controller
 *
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/category")
public class BzhProductCategoryController extends BaseController
{
    @Autowired
    private IBzhProductCategoryService bzhProductCategoryService;

    /**
     * 查询所有产品类目列表
     */
    @GetMapping("/listAll")
    public AjaxResult listAll()
    {
        List<BzhProductCategory> list = bzhProductCategoryService.selectBzhProductCategoryList(new BzhProductCategory());
        return success(list);
    }

    /**
     * 查询产品类目列表
     */
    @PreAuthorize("@ss.hasPermi('business:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhProductCategory bzhProductCategory)
    {
        startPage();
        List<BzhProductCategory> list = bzhProductCategoryService.selectBzhProductCategoryList(bzhProductCategory);
        return getDataTable(list);
    }

    /**
     * 导出产品类目列表
     */
    @PreAuthorize("@ss.hasPermi('business:category:export')")
    @Log(title = "产品类目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductCategory bzhProductCategory)
    {
        List<BzhProductCategory> list = bzhProductCategoryService.selectBzhProductCategoryList(bzhProductCategory);
        ExcelUtil<BzhProductCategory> util = new ExcelUtil<BzhProductCategory>(BzhProductCategory.class);
        util.exportExcel(response, list, "产品类目数据");
    }

    /**
     * 获取产品类目详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductCategoryService.selectBzhProductCategoryById(id));
    }

    /**
     * 新增产品类目
     */
    @PreAuthorize("@ss.hasPermi('business:category:add')")
    @Log(title = "产品类目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductCategory bzhProductCategory)
    {
        return toAjax(bzhProductCategoryService.insertBzhProductCategory(bzhProductCategory));
    }

    /**
     * 修改产品类目
     */
    @PreAuthorize("@ss.hasPermi('business:category:edit')")
    @Log(title = "产品类目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductCategory bzhProductCategory)
    {
        return toAjax(bzhProductCategoryService.updateBzhProductCategory(bzhProductCategory));
    }

    /**
     * 删除产品类目
     */
    @PreAuthorize("@ss.hasPermi('business:category:remove')")
    @Log(title = "产品类目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductCategoryService.deleteBzhProductCategoryByIds(ids));
    }
}
