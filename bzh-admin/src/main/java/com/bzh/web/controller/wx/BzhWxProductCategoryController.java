package com.bzh.web.controller.wx;

import com.bzh.business.service.IBzhProductCategoryService;
import com.bzh.business.service.IBzhStoreService;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 小程序产品类目Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/category")
public class BzhWxProductCategoryController extends BaseController
{
    @Autowired
    private IBzhProductCategoryService bzhProductCategoryService;

    /**
     * 根据storeId查询产品类目
     */
    @GetMapping("/getCategoryListByStoreId")
    public AjaxResult getCategoryListByStoreId(@RequestParam("storeId") Long storeId)
    {
        return success(bzhProductCategoryService.getCategoryListByStoreId(storeId));
    }

}
