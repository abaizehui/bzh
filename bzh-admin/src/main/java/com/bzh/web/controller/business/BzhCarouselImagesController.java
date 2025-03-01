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
import com.bzh.business.domain.BzhCarouselImages;
import com.bzh.business.service.IBzhCarouselImagesService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/business/carousel")
public class BzhCarouselImagesController extends BaseController
{
    @Autowired
    private IBzhCarouselImagesService bzhCarouselImagesService;

    /**
     * 查询轮播图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhCarouselImages bzhCarouselImages)
    {
        startPage();
        List<BzhCarouselImages> list = bzhCarouselImagesService.selectBzhCarouselImagesList(bzhCarouselImages);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhCarouselImages bzhCarouselImages)
    {
        List<BzhCarouselImages> list = bzhCarouselImagesService.selectBzhCarouselImagesList(bzhCarouselImages);
        ExcelUtil<BzhCarouselImages> util = new ExcelUtil<BzhCarouselImages>(BzhCarouselImages.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhCarouselImagesService.selectBzhCarouselImagesById(id));
    }

    /**
     * 新增轮播图
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhCarouselImages bzhCarouselImages)
    {
        return toAjax(bzhCarouselImagesService.insertBzhCarouselImages(bzhCarouselImages));
    }

    /**
     * 修改轮播图
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhCarouselImages bzhCarouselImages)
    {
        return toAjax(bzhCarouselImagesService.updateBzhCarouselImages(bzhCarouselImages));
    }

    /**
     * 删除轮播图
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhCarouselImagesService.deleteBzhCarouselImagesByIds(ids));
    }
}
