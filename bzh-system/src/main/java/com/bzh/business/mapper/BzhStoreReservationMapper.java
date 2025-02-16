package com.bzh.business.mapper;

import java.util.List;
import com.bzh.business.domain.BzhStoreReservation;

/**
 * 门店预约Mapper接口
 * 
 * @author bzh
 * @date 2025-02-16
 */
public interface BzhStoreReservationMapper 
{
    /**
     * 查询门店预约
     * 
     * @param id 门店预约主键
     * @return 门店预约
     */
    public BzhStoreReservation selectBzhStoreReservationById(Long id);

    /**
     * 查询门店预约列表
     * 
     * @param bzhStoreReservation 门店预约
     * @return 门店预约集合
     */
    public List<BzhStoreReservation> selectBzhStoreReservationList(BzhStoreReservation bzhStoreReservation);

    /**
     * 新增门店预约
     * 
     * @param bzhStoreReservation 门店预约
     * @return 结果
     */
    public int insertBzhStoreReservation(BzhStoreReservation bzhStoreReservation);

    /**
     * 修改门店预约
     * 
     * @param bzhStoreReservation 门店预约
     * @return 结果
     */
    public int updateBzhStoreReservation(BzhStoreReservation bzhStoreReservation);

    /**
     * 删除门店预约
     * 
     * @param id 门店预约主键
     * @return 结果
     */
    public int deleteBzhStoreReservationById(Long id);

    /**
     * 批量删除门店预约
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBzhStoreReservationByIds(Long[] ids);
}
