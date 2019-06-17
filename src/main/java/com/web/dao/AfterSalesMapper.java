package com.web.dao;

import com.web.model.AfterSales;
import com.web.model.AfterSalesExample;
import java.util.List;

import com.web.model.Order;
import org.apache.ibatis.annotations.Param;

public interface AfterSalesMapper {
    int countByExample(AfterSalesExample example);

    int deleteByExample(AfterSalesExample example);

    int deleteByPrimaryKey(Integer afterSalesId);

    int insert(AfterSales record);

    int insertSelective(AfterSales record);

    List<AfterSales> selectByExample(AfterSalesExample example);

    AfterSales selectByPrimaryKey(Integer afterSalesId);

    int updateByExampleSelective(@Param("record") AfterSales record, @Param("example") AfterSalesExample example);

    int updateByExample(@Param("record") AfterSales record, @Param("example") AfterSalesExample example);

    int updateByPrimaryKeySelective(AfterSales record);

    int updateByPrimaryKey(AfterSales record);

    public List<AfterSales> selectAfterSalesByPage(@Param(value = "startPos") Integer startPos,
                                                    @Param(value = "pageSize") Integer pageSize);
    public long getAfterSalesCount();

    public List<AfterSales> likeQuery(String orderInformation);

    public List<AfterSales> selectAfterSaleByOrderId(@Param(value = "orderId")String orderId, @Param(value = "startPos") Integer startPos,
                                           @Param(value = "pageSize") Integer pageSize);
    public long getAfterSaleCountByOrderId(String orderId);

    List<AfterSales> selectAllByOrderId(@Param(value = "orderId")String OrderId);


}