package com.bzh.business.service.impl;

import java.util.List;
import com.bzh.common.utils.DateUtils;
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
        return bzhStoreReservationMapper.selectBzhStoreReservationList(bzhStoreReservation);
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
        return bzhStoreReservationMapper.insertBzhStoreReservation(bzhStoreReservation);
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
