package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.service.IBzhShareService;
import com.bzh.business.service.IBzhStoreReservationService;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * 小程序分享Controller
 *
 * @author bzh
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/wx/share")
public class BzhWxShareController extends BaseController
{
    @Autowired
    private IBzhShareService bzhShareService;

    @Autowired
    private IBzhStoreReservationService bzhStoreReservationService;

    /**
     * 获取手机号
     */
    @GetMapping("/getPhoneNumber")
    public AjaxResult getPhoneNumber(@RequestParam("code") String code)
    {
        return success(bzhShareService.getPhoneNumber(code));
    }

    /**
     * 提交预约
     */
    @GetMapping("/submit")
    public AjaxResult submit(@RequestParam("storeId") String storeId,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam(value = "productId",required = false) Long productId)
    {
        BzhStoreReservation bzhStoreReservation = new BzhStoreReservation();
        bzhStoreReservation.setName(name);
        bzhStoreReservation.setPhone(phone);
        if (Objects.nonNull(productId)) {
            bzhStoreReservation.setProductId(productId);
        }
        return success(bzhStoreReservationService.insertBzhStoreReservation(bzhStoreReservation));
    }

}
