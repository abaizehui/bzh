package com.bzh.web.controller.wx;

import com.bzh.business.service.IBzhStoreService;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 小程序门店Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/store")
public class BzhWxStoreController extends BaseController
{
    @Autowired
    private IBzhStoreService bzhStoreService;

    /**
     * 根据appid查询门店
     */
    @GetMapping("/getStoreByAppId")
    public AjaxResult getStoreByAppId(@RequestParam("appId") String appId)
    {
        return success(bzhStoreService.getStoreByAppId(appId));
    }

}
