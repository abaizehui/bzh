package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhCarouselImages;
import com.bzh.business.service.IBzhCarouselImagesService;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.common.core.page.TableDataInfo;
import com.bzh.common.utils.poi.ExcelUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 小程序轮播图Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/carousel")
public class BzhWxCarouselImagesController extends BaseController
{
    @Autowired
    private IBzhCarouselImagesService bzhCarouselImagesService;

    /**
     * 查询轮播图列表
     */
    @GetMapping("/getCarouselList")
    public AjaxResult getCarouselList(@RequestParam("storeId") Long storeId)
    {
        BzhCarouselImages bzhCarouselImages = new BzhCarouselImages();
        bzhCarouselImages.setStoreId(storeId);
        bzhCarouselImages.setStatus(Constants.STATUS_YES);
        return success(bzhCarouselImagesService.selectList(bzhCarouselImages));
    }

}
