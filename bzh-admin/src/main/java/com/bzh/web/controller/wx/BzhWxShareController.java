package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.service.IBzhStoreReservationService;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


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
    private IBzhStoreReservationService bzhStoreReservationService;

    @Autowired
    private RedisCache redisCache;


    /**
     * 提交预约
     */
    @GetMapping("/submit")
    public AjaxResult submit(@RequestParam("storeId") Long storeId,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam(value = "productId",required = false) Long productId,
                             @RequestParam(value = "inviterUserId",required = false) Long inviterUserId)
    {
        Object result = redisCache.getCacheObject(getSubmitShareKey(phone,storeId));
        if (Objects.nonNull(result)) {
            return success();
        }
        BzhStoreReservation bzhStoreReservation = new BzhStoreReservation();
        bzhStoreReservation.setName(name);
        bzhStoreReservation.setPhone(phone);
        bzhStoreReservation.setStoreId(storeId);
        bzhStoreReservation.setInviterUserId(inviterUserId);
        if (Objects.nonNull(productId)) {
            bzhStoreReservation.setProductId(productId);
        }
        bzhStoreReservationService.insertBzhStoreReservation(bzhStoreReservation);
        redisCache.setCacheObject(getSubmitShareKey(phone,storeId), phone, Constants.EXPIRATION, TimeUnit.HOURS);
        return success();
    }

    private String getSubmitShareKey(String phone,Long storeId){
        return Constants.SUBMIT_SHARE_KEY+phone+Constants.WELL+storeId;
    }

}
