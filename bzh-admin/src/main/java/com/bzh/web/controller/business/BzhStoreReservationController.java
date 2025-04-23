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
import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.service.IBzhStoreReservationService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 门店预约Controller
 *
 * @author bzh
 * @date 2025-02-16
 */
@RestController
@RequestMapping("/business/reservation")
public class BzhStoreReservationController extends BaseController
{
    @Autowired
    private IBzhStoreReservationService bzhStoreReservationService;

    /**
     * 查询门店预约列表
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(BzhStoreReservation bzhStoreReservation)
    {
        startPage();
        List<BzhStoreReservation> list = bzhStoreReservationService.selectBzhStoreReservationList(bzhStoreReservation);
        return getDataTable(list);
    }

    /**
     * 导出门店预约列表
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:export')")
    @Log(title = "门店预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhStoreReservation bzhStoreReservation)
    {
        List<BzhStoreReservation> list = bzhStoreReservationService.selectBzhStoreReservationList(bzhStoreReservation);
        ExcelUtil<BzhStoreReservation> util = new ExcelUtil<BzhStoreReservation>(BzhStoreReservation.class);
        util.exportExcel(response, list, "门店预约数据");
    }

    /**
     * 获取门店预约详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhStoreReservationService.selectBzhStoreReservationById(id));
    }

    /**
     * 新增门店预约
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:add')")
    @Log(title = "门店预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BzhStoreReservation bzhStoreReservation)
    {
        return toAjax(bzhStoreReservationService.insertBzhStoreReservation(bzhStoreReservation));
    }

    /**
     * 修改门店预约
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:edit')")
    @Log(title = "门店预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BzhStoreReservation bzhStoreReservation)
    {
        return toAjax(bzhStoreReservationService.updateBzhStoreReservation(bzhStoreReservation));
    }

    /**
     * 删除门店预约
     */
    @PreAuthorize("@ss.hasPermi('business:reservation:remove')")
    @Log(title = "门店预约", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhStoreReservationService.deleteBzhStoreReservationByIds(ids));
    }
}
