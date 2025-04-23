package com.bzh.business.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bzh.business.domain.BzhProduct;
import com.bzh.business.domain.BzhProductSet;
import com.bzh.business.domain.BzhWechatUser;
import com.bzh.business.mapper.BzhProductMapper;
import com.bzh.business.mapper.BzhProductSetMapper;
import com.bzh.business.mapper.BzhWechatUserMapper;
import com.bzh.common.utils.DateUtils;
import com.bzh.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bzh.business.mapper.BzhStoreReservationMapper;
import com.bzh.business.domain.BzhStoreReservation;
import com.bzh.business.service.IBzhStoreReservationService;

/**
 * 门店预约Service业务层处理
 *
 * @author bzh
 * @date 2025-02-16
 */
@Service
public class BzhStoreReservationServiceImpl implements IBzhStoreReservationService
{
    @Autowired
    private BzhStoreReservationMapper bzhStoreReservationMapper;
    @Autowired
    private BzhProductMapper bzhProductMapper;
    @Autowired
    private BzhWechatUserMapper bzhWechatUserMapper;
    @Autowired
    private BzhProductSetMapper bzhProductSetMapper;

    /**
     * 查询门店预约
     *
     * @param id 门店预约主键
     * @return 门店预约
     */
    @Override
    public BzhStoreReservation selectBzhStoreReservationById(Long id)
    {
        return bzhStoreReservationMapper.selectBzhStoreReservationById(id);
    }

    /**
     * 查询门店预约列表
     *
     * @param bzhStoreReservation 门店预约
     * @return 门店预约
     */
    @Override
    public List<BzhStoreReservation> selectBzhStoreReservationList(BzhStoreReservation bzhStoreReservation)
    {

        List<BzhProduct> productList = bzhProductMapper.selectBzhProductList(new BzhProduct());
        Map<Long, BzhProduct> map = productList.stream().collect(Collectors.toMap(BzhProduct::getId, Function.identity()));
        List<BzhStoreReservation> bzhStoreReservations = bzhStoreReservationMapper.selectBzhStoreReservationList(bzhStoreReservation);
        bzhStoreReservations.forEach(reservation -> {
            BzhProduct bzhProduct = map.get(reservation.getProductId());
            if (Objects.nonNull(bzhProduct)) {
                reservation.setProductName(bzhProduct.getProductName());

            }
        });
        return bzhStoreReservations;
    }

    /**
     * 新增门店预约
     *
     * @param bzhStoreReservation 门店预约
     * @return 结果
     */
    @Override
    public int insertBzhStoreReservation(BzhStoreReservation bzhStoreReservation)
    {
        bzhStoreReservation.setCreateTime(DateUtils.getNowDate());
        int num = bzhStoreReservationMapper.insertBzhStoreReservation(bzhStoreReservation);

        String shareType = "预约到店";
        String productContent = "";
        String sharePhoneNumber = "";
        if (Objects.nonNull(bzhStoreReservation.getProductId())) {
            BzhProduct bzhProduct = bzhProductMapper.selectBzhProductById(bzhStoreReservation.getProductId());
            if (Objects.nonNull(bzhProduct)) {
                productContent = "产品名称: <font color=\\\"comment\\\">"+bzhProduct.getProductName()+"</font>\\n> ";
            }
            shareType = "产品预约";
        }
        if (Objects.nonNull(bzhStoreReservation.getSetId())) {
            BzhProductSet bzhProductSet = bzhProductSetMapper.selectBzhProductSetById(bzhStoreReservation.getSetId());
            if (Objects.nonNull(bzhProductSet)) {
                productContent = "产品名称: <font color=\\\"comment\\\">"+bzhProductSet.getProductName()+"</font>\\n> ";
            }
            shareType = "套装预约";
        }
        if (Objects.nonNull(bzhStoreReservation.getInviterUserId())) {
            BzhWechatUser bzhWechatUser = bzhWechatUserMapper.selectBzhWechatUserById(bzhStoreReservation.getInviterUserId());
            if (Objects.nonNull(bzhWechatUser)) {
                sharePhoneNumber = "分享人手机号: <font color=\\\"comment\\\">"+bzhWechatUser.getPhoneNumber()+"</font>\\n> ";
            }
        }
        String content = "新增预约用户:\\n> " +
                "姓名: <font color=\\\"comment\\\">"+bzhStoreReservation.getName()+"</font>\\n> " +
                "预约用户手机号: <font color=\\\"comment\\\">"+bzhStoreReservation.getPhone()+"</font>\\n> " +
                 productContent +
                 sharePhoneNumber +
                "预约类型: <font color=\\\"comment\\\">"+shareType+"</font>";
        sendMarkdownMessage(content);
        return num;
    }

    private static final String WEBHOOK_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=ff178b1c-47d5-41f4-becb-ac4585f13777";

    public static void sendMarkdownMessage(String content) {
        // 构建消息体
        String json = "{\"msgtype\": \"markdown\", \"markdown\": {\"content\": \"" + content + "\"}}";
        String s = HttpUtils.sendPost(WEBHOOK_URL, json);

    }

    /**
     * 修改门店预约
     *
     * @param bzhStoreReservation 门店预约
     * @return 结果
     */
    @Override
    public int updateBzhStoreReservation(BzhStoreReservation bzhStoreReservation)
    {
        bzhStoreReservation.setUpdateTime(DateUtils.getNowDate());
        return bzhStoreReservationMapper.updateBzhStoreReservation(bzhStoreReservation);
    }

    /**
     * 批量删除门店预约
     *
     * @param ids 需要删除的门店预约主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreReservationByIds(Long[] ids)
    {
        return bzhStoreReservationMapper.deleteBzhStoreReservationByIds(ids);
    }

    /**
     * 删除门店预约信息
     *
     * @param id 门店预约主键
     * @return 结果
     */
    @Override
    public int deleteBzhStoreReservationById(Long id)
    {
        return bzhStoreReservationMapper.deleteBzhStoreReservationById(id);
    }
}
