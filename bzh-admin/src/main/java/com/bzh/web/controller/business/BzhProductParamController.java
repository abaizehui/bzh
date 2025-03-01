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
import com.bzh.business.domain.BzhProductParam;
import com.bzh.business.service.IBzhProductParamService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品参数Controller
 *
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/param")
public class BzhProductParamController extends BaseController
{
    @Autowired
    private IBzhProductParamService bzhProductParamService;

    /**
     * 查询商品参数列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhProductParam bzhProductParam)
    {
        startPage();
        List<BzhProductParam> list = bzhProductParamService.selectBzhProductParamList(bzhProductParam);
        return getDataTable(list);
    }

    /**
     * 导出商品参数列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductParam bzhProductParam)
    {
        List<BzhProductParam> list = bzhProductParamService.selectBzhProductParamList(bzhProductParam);
        ExcelUtil<BzhProductParam> util = new ExcelUtil<BzhProductParam>(BzhProductParam.class);
        util.exportExcel(response, list, "商品参数数据");
    }

    /**
     * 获取商品参数详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductParamService.selectBzhProductParamById(id));
    }

    /**
     * 新增商品参数
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductParam bzhProductParam)
    {
        return toAjax(bzhProductParamService.insertBzhProductParam(bzhProductParam));
    }

    /**
     * 修改商品参数
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductParam bzhProductParam)
    {
        return toAjax(bzhProductParamService.updateBzhProductParam(bzhProductParam));
    }

    /**
     * 删除商品参数
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductParamService.deleteBzhProductParamByIds(ids));
    }
}
