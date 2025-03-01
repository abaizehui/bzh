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
import com.bzh.common.annotation.Log;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.common.enums.BusinessType;
import com.bzh.business.domain.BzhProductDetailImage;
import com.bzh.business.service.IBzhProductDetailImageService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品详情图Controller
 *
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/detail")
public class BzhProductDetailImageController extends BaseController
{
    @Autowired
    private IBzhProductDetailImageService bzhProductDetailImageService;

    /**
     * 查询商品详情图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhProductDetailImage bzhProductDetailImage)
    {
        startPage();
        List<BzhProductDetailImage> list = bzhProductDetailImageService.selectBzhProductDetailImageList(bzhProductDetailImage);
        return getDataTable(list);
    }

    /**
     * 导出商品详情图列表
     */
    @Log(title = "商品详情图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductDetailImage bzhProductDetailImage)
    {
        List<BzhProductDetailImage> list = bzhProductDetailImageService.selectBzhProductDetailImageList(bzhProductDetailImage);
        ExcelUtil<BzhProductDetailImage> util = new ExcelUtil<BzhProductDetailImage>(BzhProductDetailImage.class);
        util.exportExcel(response, list, "商品详情图数据");
    }

    /**
     * 获取商品详情图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductDetailImageService.selectBzhProductDetailImageById(id));
    }

    /**
     * 新增商品详情图
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductDetailImage bzhProductDetailImage)
    {
        return toAjax(bzhProductDetailImageService.insertBzhProductDetailImage(bzhProductDetailImage));
    }

    /**
     * 修改商品详情图
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductDetailImage bzhProductDetailImage)
    {
        return toAjax(bzhProductDetailImageService.updateBzhProductDetailImage(bzhProductDetailImage));
    }

    /**
     * 删除商品详情图
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductDetailImageService.deleteBzhProductDetailImageByIds(ids));
    }
}
