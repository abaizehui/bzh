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
import com.bzh.business.domain.BzhProductSet;
import com.bzh.business.service.IBzhProductSetService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品套装Controller
 *
 * @author bzh
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/business/set")
public class BzhProductSetController extends BaseController
{
    @Autowired
    private IBzhProductSetService bzhProductSetService;

    /**
     * 查询商品套装列表
     */
    @PreAuthorize("@ss.hasPermi('business:set:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhProductSet bzhProductSet)
    {
        startPage();
        List<BzhProductSet> list = bzhProductSetService.selectBzhProductSetList(bzhProductSet);
        return getDataTable(list);
    }

    /**
     * 导出商品套装列表
     */
    @PreAuthorize("@ss.hasPermi('business:set:export')")
    @Log(title = "商品套装", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductSet bzhProductSet)
    {
        List<BzhProductSet> list = bzhProductSetService.selectBzhProductSetList(bzhProductSet);
        ExcelUtil<BzhProductSet> util = new ExcelUtil<BzhProductSet>(BzhProductSet.class);
        util.exportExcel(response, list, "商品套装数据");
    }

    /**
     * 获取商品套装详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:set:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductSetService.selectBzhProductSetById(id));
    }

    /**
     * 新增商品套装
     */
    @PreAuthorize("@ss.hasPermi('business:set:add')")
    @Log(title = "商品套装", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductSet bzhProductSet)
    {
        return toAjax(bzhProductSetService.insertBzhProductSet(bzhProductSet));
    }

    /**
     * 修改商品套装
     */
    @PreAuthorize("@ss.hasPermi('business:set:edit')")
    @Log(title = "商品套装", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductSet bzhProductSet)
    {
        return toAjax(bzhProductSetService.updateBzhProductSet(bzhProductSet));
    }

    /**
     * 删除商品套装
     */
    @PreAuthorize("@ss.hasPermi('business:set:remove')")
    @Log(title = "商品套装", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductSetService.deleteBzhProductSetByIds(ids));
    }
}
