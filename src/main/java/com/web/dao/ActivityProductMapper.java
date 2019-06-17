package com.web.dao;

import com.web.model.ActivityProduct;
import com.web.model.ActivityProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityProductMapper {
    int countByExample(ActivityProductExample example);

    int deleteByExample(ActivityProductExample example);

    int deleteByPrimaryKey(Integer activityProductId);

    int insert(ActivityProduct record);

    int insertSelective(ActivityProduct record);

    List<ActivityProduct> selectByExample(ActivityProductExample example);

    ActivityProduct selectByPrimaryKey(Integer activityProductId);

    int updateByExampleSelective(@Param("record") ActivityProduct record, @Param("example") ActivityProductExample example);

    int updateByExample(@Param("record") ActivityProduct record, @Param("example") ActivityProductExample example);

    int updateByPrimaryKeySelective(ActivityProduct record);

    int updateByPrimaryKey(ActivityProduct record);
}