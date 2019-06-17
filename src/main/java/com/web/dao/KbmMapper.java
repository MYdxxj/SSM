package com.web.dao;

import com.web.model.Kbm;
import com.web.model.KbmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KbmMapper {
    int countByExample(KbmExample example);

    int deleteByExample(KbmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kbm record);

    int insertSelective(Kbm record);

    List<Kbm> selectByExample(KbmExample example);

    Kbm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kbm record, @Param("example") KbmExample example);

    int updateByExample(@Param("record") Kbm record, @Param("example") KbmExample example);

    int updateByPrimaryKeySelective(Kbm record);

    int updateByPrimaryKey(Kbm record);
}