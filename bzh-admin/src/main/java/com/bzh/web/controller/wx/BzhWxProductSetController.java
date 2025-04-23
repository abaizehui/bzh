package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhProductSet;
import com.bzh.business.service.IBzhProductSetService;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 小程序商品Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/product/set")
public class BzhWxProductSetController extends BaseController
{
    @Autowired
    private IBzhProductSetService bzhProductSetService;

    /**
     * 根据门店id查询推荐套装列表
     */
    @GetMapping("/getProductSetListByStoreId")
    public AjaxResult getProductSetListByStoreId(@RequestParam("storeId") Long storeId)
    {
        BzhProductSet bzhProductSet = new BzhProductSet();
        bzhProductSet.setStoreId(storeId);
        bzhProductSet.setStatus(Constants.STATUS_YES);
        return success(bzhProductSetService.selectList(bzhProductSet));
    }

    /**
     * 根据套装id查询套装详情
     */
    @GetMapping("/getProductSetBySetId")
    public AjaxResult getProductSetBySetId(@RequestParam("productSetId") Long productSetId)
    {
        return success(bzhProductSetService.getProductSetBySetId(productSetId));
    }




}
