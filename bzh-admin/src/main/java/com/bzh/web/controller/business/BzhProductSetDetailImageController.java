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
import com.bzh.business.domain.BzhProductSetDetailImage;
import com.bzh.business.service.IBzhProductSetDetailImageService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 商品套装详情图Controller
 *
 * @author bzh
 * @date 2025-04-02
 */
@RestController
@RequestMapping("/business/image")
public class BzhProductSetDetailImageController extends BaseController
{
    @Autowired
    private IBzhProductSetDetailImageService bzhProductSetDetailImageService;

    /**
     * 查询商品套装详情图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        startPage();
        List<BzhProductSetDetailImage> list = bzhProductSetDetailImageService.selectBzhProductSetDetailImageList(bzhProductSetDetailImage);
        return getDataTable(list);
    }

    /**
     * 导出商品套装详情图列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        List<BzhProductSetDetailImage> list = bzhProductSetDetailImageService.selectBzhProductSetDetailImageList(bzhProductSetDetailImage);
        ExcelUtil<BzhProductSetDetailImage> util = new ExcelUtil<BzhProductSetDetailImage>(BzhProductSetDetailImage.class);
        util.exportExcel(response, list, "商品套装详情图数据");
    }

    /**
     * 获取商品套装详情图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhProductSetDetailImageService.selectBzhProductSetDetailImageById(id));
    }

    /**
     * 新增商品套装详情图
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        return toAjax(bzhProductSetDetailImageService.insertBzhProductSetDetailImage(bzhProductSetDetailImage));
    }

    /**
     * 修改商品套装详情图
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhProductSetDetailImage bzhProductSetDetailImage)
    {
        return toAjax(bzhProductSetDetailImageService.updateBzhProductSetDetailImage(bzhProductSetDetailImage));
    }

    /**
     * 删除商品套装详情图
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhProductSetDetailImageService.deleteBzhProductSetDetailImageByIds(ids));
    }
}
