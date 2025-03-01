
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
import com.bzh.business.domain.BzhProductSceneImage;
import com.bzh.business.service.IBzhProductSceneImageService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品实景图Controller
 *
 * @author bzh
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/business/scene")
public class BzhProductSceneImageController extends BaseController
{
    @Autowired
    private IBzhProductSceneImageService bzhProductSceneImageService;

    /**
     * 查询商品实景图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhProductSceneImage bzhProductSceneImage)
    {
        startPage();
        List<BzhProductSceneImage> list = bzhProductSceneImageService.selectBzhProductSceneImageList(bzhProductSceneImage);
        return getDataTable(list);
    }

    /**
     * 导出商品实景图列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductSceneImage bzhProductSceneImage)
    {
        List<BzhProductSceneImage> list = bzhProductSceneImageService.selectBzhProductSceneImageList(bzhProductSceneImage);
        ExcelUtil<BzhProductSceneImage> util = new ExcelUtil<BzhProductSceneImage>(BzhProductSceneImage.class);
        util.exportExcel(response, list, "商品实景图数据");
    }

    /**
     * 获取商品实景图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductSceneImageService.selectBzhProductSceneImageById(id));
    }

    /**
     * 新增商品实景图
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductSceneImage bzhProductSceneImage)
    {
        return toAjax(bzhProductSceneImageService.insertBzhProductSceneImage(bzhProductSceneImage));
    }

    /**
     * 修改商品实景图
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductSceneImage bzhProductSceneImage)
    {
        return toAjax(bzhProductSceneImageService.updateBzhProductSceneImage(bzhProductSceneImage));
    }

    /**
     * 删除商品实景图
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductSceneImageService.deleteBzhProductSceneImageByIds(ids));
    }
}
