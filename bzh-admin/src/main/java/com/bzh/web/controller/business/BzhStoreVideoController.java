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
import com.bzh.business.domain.BzhStoreVideo;
import com.bzh.business.service.IBzhStoreVideoService;
import com.bzh.common.utils.poi.ExcelUtil;
import com.bzh.common.core.page.TableDataInfo;

/**
 * 门店视频Controller
 *
 * @author bzh
 * @date 2025-04-23
 */
@RestController
@RequestMapping("/business/video")
public class BzhStoreVideoController extends BaseController
{
    @Autowired
    private IBzhStoreVideoService bzhStoreVideoService;

    /**
     * 查询门店视频列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BzhStoreVideo bzhStoreVideo)
    {
        startPage();
        List<BzhStoreVideo> list = bzhStoreVideoService.selectBzhStoreVideoList(bzhStoreVideo);
        return getDataTable(list);
    }

    /**
     * 导出门店视频列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, BzhStoreVideo bzhStoreVideo)
    {
        List<BzhStoreVideo> list = bzhStoreVideoService.selectBzhStoreVideoList(bzhStoreVideo);
        ExcelUtil<BzhStoreVideo> util = new ExcelUtil<BzhStoreVideo>(BzhStoreVideo.class);
        util.exportExcel(response, list, "门店视频数据");
    }

    /**
     * 获取门店视频详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bzhStoreVideoService.selectBzhStoreVideoById(id));
    }

    /**
     * 新增门店视频
     */
    @PostMapping
    public AjaxResult add(@RequestBody BzhStoreVideo bzhStoreVideo)
    {
        return toAjax(bzhStoreVideoService.insertBzhStoreVideo(bzhStoreVideo));
    }

    /**
     * 修改门店视频
     */
    @PutMapping
    public AjaxResult edit(@RequestBody BzhStoreVideo bzhStoreVideo)
    {
        return toAjax(bzhStoreVideoService.updateBzhStoreVideo(bzhStoreVideo));
    }

    /**
     * 删除门店视频
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bzhStoreVideoService.deleteBzhStoreVideoByIds(ids));
    }
}
