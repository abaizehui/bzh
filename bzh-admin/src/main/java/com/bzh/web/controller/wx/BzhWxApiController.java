package com.bzh.web.controller.wx;

import com.bzh.business.service.IBzhWxApiService;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 小程序api Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/api")
public class BzhWxApiController extends BaseController
{

    @Autowired
    private IBzhWxApiService bzhWxApiService;

    /**
     * 获取手机号
     */
    @GetMapping("/getPhoneNumber")
    public AjaxResult getPhoneNumber(@RequestParam("code") String code)
    {
        return success(bzhWxApiService.getPhoneNumber(code));
    }


    /**
     * 登陆
     */
    @GetMapping("/login")
    public AjaxResult login(@RequestParam("code") String code,@RequestParam("phoneNumber") String phoneNumber)
    {
        return success(bzhWxApiService.login(code,phoneNumber));
    }


}
