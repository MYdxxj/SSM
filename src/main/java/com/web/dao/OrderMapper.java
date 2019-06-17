package com.web.dao;

import com.web.model.Order;
import com.web.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    public List<Order> selectOrderByPage(@Param(value = "startPos") Integer startPos,
                                       @Param(value = "pageSize") Integer pageSize);
    public long getOrderCount();

    public List<Order> selectOrderByUserId(@Param(value = "userId")String userId,@Param(value = "startPos") Integer startPos,
                                         @Param(value = "pageSize") Integer pageSize);
    public long getUserOrderCount(String userId);

    public List<Order> selectByUserId(String userId);
}