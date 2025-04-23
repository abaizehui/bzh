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
import com.bzh.business.domain.BzhStore;
import com.bzh.business.service.IBzhStoreService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 门店Controller
 *
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/store")
public class BzhStoreController extends BaseController
{
    @Autowired
    private IBzhStoreService bzhStoreService;

    /**
     * 查询门店列表
     */
    @GetMapping("/listAll")
    public AjaxResult listAll()
    {
        BzhStore bzhStore = new BzhStore();
        bzhStore.setStatus("0");
        return success(bzhStoreService.selectBzhStoreList(bzhStore));
    }

    /**
     * 查询门店列表
     */
    @PreAuthorize("@ss.hasPermi('business:store:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhStore bzhStore)
    {

        startPage();
        List<BzhStore> list = bzhStoreService.selectBzhStoreList(bzhStore);
        return getDataTable(list);
    }

    /**
     * 导出门店列表
     */
    @PreAuthorize("@ss.hasPermi('business:store:export')")
    @Log(title = "门店", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhStore bzhStore)
    {
        List<BzhStore> list = bzhStoreService.selectBzhStoreList(bzhStore);
        ExcelUtil<BzhStore> util = new ExcelUtil<BzhStore>(BzhStore.class);
        util.exportExcel(response, list, "门店数据");
    }

    /**
     * 获取门店详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:store:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhStoreService.selectBzhStoreById(id));
    }

    /**
     * 新增门店
     */
    @PreAuthorize("@ss.hasPermi('business:store:add')")
    @Log(title = "门店", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhStore bzhStore)
    {
        return toAjax(bzhStoreService.insertBzhStore(bzhStore));
    }

    /**
     * 修改门店
     */
    @PreAuthorize("@ss.hasPermi('business:store:edit')")
    @Log(title = "门店", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhStore bzhStore)
    {
        return toAjax(bzhStoreService.updateBzhStore(bzhStore));
    }

    /**
     * 删除门店
     */
    @PreAuthorize("@ss.hasPermi('business:store:remove')")
    @Log(title = "门店", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhStoreService.deleteBzhStoreByIds(ids));
    }
}
