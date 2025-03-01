package com.bzh.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.business.domain.BzhProductConfig;
import com.bzh.business.service.IBzhProductConfigService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品功能配置Controller
 *
 * @author bzh
 * @date 2025-03-01
 */
@RestController
@RequestMapping("/business/config")
public class BzhProductConfigController extends BaseController
{
    @Autowired
    private IBzhProductConfigService bzhProductConfigService;

    /**
     * 查询商品功能配置列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhProductConfig bzhProductConfig)
    {
        startPage();
        List<BzhProductConfig> list = bzhProductConfigService.selectBzhProductConfigList(bzhProductConfig);
        return getDataTable(list);
    }

    /**
     * 导出商品功能配置列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductConfig bzhProductConfig)
    {
        List<BzhProductConfig> list = bzhProductConfigService.selectBzhProductConfigList(bzhProductConfig);
        ExcelUtil<BzhProductConfig> util = new ExcelUtil<BzhProductConfig>(BzhProductConfig.class);
        util.exportExcel(response, list, "商品功能配置数据");
    }

    /**
     * 获取商品功能配置详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductConfigService.selectBzhProductConfigById(id));
    }

    /**
     * 新增商品功能配置
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductConfig bzhProductConfig)
    {
        return toAjax(bzhProductConfigService.insertBzhProductConfig(bzhProductConfig));
    }

    /**
     * 修改商品功能配置
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductConfig bzhProductConfig)
    {
        return toAjax(bzhProductConfigService.updateBzhProductConfig(bzhProductConfig));
    }

    /**
     * 删除商品功能配置
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductConfigService.deleteBzhProductConfigByIds(ids));
    }
}
