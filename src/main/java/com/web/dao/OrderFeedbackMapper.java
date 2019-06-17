package com.web.dao;

import com.web.model.OrderFeedback;
import com.web.model.OrderFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFeedbackMapper {
    int countByExample(OrderFeedbackExample example);

    int deleteByExample(OrderFeedbackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(OrderFeedback record);

    int insertSelective(OrderFeedback record);

    List<OrderFeedback> selectByExample(OrderFeedbackExample example);

    OrderFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByExampleSelective(@Param("record") OrderFeedback record, @Param("example") OrderFeedbackExample example);

    int updateByExample(@Param("record") OrderFeedback record, @Param("example") OrderFeedbackExample example);

    int updateByPrimaryKeySelective(OrderFeedback record);

    int updateByPrimaryKey(OrderFeedback record);

    public List<OrderFeedback> selectFeedbackByPage(@Param(value = "startPos") Integer startPos,
                                                    @Param(value = "pageSize") Integer pageSize);
    public long getFeedbackCount();

    public List<OrderFeedback> likeQuery(String userInput);
}