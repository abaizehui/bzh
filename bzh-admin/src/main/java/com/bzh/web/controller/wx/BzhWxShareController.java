package com.bzh.web.controller.wx;

import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.req.BzhShareSubmitReq;
import com.bzh.business.service.IBzhStoreReservationService;
import com.bzh.common.constant.Constants;
import com.bzh.common.core.controller.BaseController;
import com.bzh.common.core.domain.AjaxResult;
import com.bzh.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody BzhShareSubmitReq bzhShareSubmitReq)
    {
        String phone = bzhShareSubmitReq.getPhone();
        Long storeId = bzhShareSubmitReq.getStoreId();
        String name = bzhShareSubmitReq.getName();
        Long inviterUserId = bzhShareSubmitReq.getInviterUserId();
        Long productId = bzhShareSubmitReq.getProductId();
        Long productSetId = bzhShareSubmitReq.getProductSetId();
        Object result = redisCache.getCacheObject(getSubmitShareKey(phone,storeId));
        if (Objects.nonNull(result)) {
            return success();
        }
        BzhStoreReservation bzhStoreReservation = new BzhStoreReservation();
        bzhStoreReservation.setName(name);
        bzhStoreReservation.setPhone(phone);
        bzhStoreReservation.setStoreId(storeId);

        if (Objects.nonNull(productId)) {
            bzhStoreReservation.setProductId(productId);
        }
        if (Objects.nonNull(inviterUserId)) {
            bzhStoreReservation.setInviterUserId(inviterUserId);
        }
        if (Objects.nonNull(productSetId)) {
            bzhStoreReservation.setSetId(productSetId);
        }
        bzhStoreReservationService.insertBzhStoreReservation(bzhStoreReservation);
        redisCache.setCacheObject(getSubmitShareKey(phone,storeId), phone, Constants.EXPIRATION, TimeUnit.MINUTES);
        return success();
    }

    private String getSubmitShareKey(String phone,Long storeId){
        return Constants.SUBMIT_SHARE_KEY+phone+Constants.WELL+storeId;
    }

}
