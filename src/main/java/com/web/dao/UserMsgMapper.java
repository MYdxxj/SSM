package com.web.dao;

import com.web.model.UserMsg;
import com.web.model.UserMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMsgMapper {
    int countByExample(UserMsgExample example);

    int deleteByExample(UserMsgExample example);

    int deleteByPrimaryKey(Integer userMsgId);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    List<UserMsg> selectByExample(UserMsgExample example);

    UserMsg selectByPrimaryKey(Integer userMsgId);

    int updateByExampleSelective(@Param("record") UserMsg record, @Param("example") UserMsgExample example);

    int updateByExample(@Param("record") UserMsg record, @Param("example") UserMsgExample example);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKey(UserMsg record);

    public List<UserMsg> selectUserMsgByPage(@Param(value = "startPos") Integer startPos,
                                       @Param(value = "pageSize") Integer pageSize);
    public long getUserMsgCount();

    public List<UserMsg> likeQuery(String userInput);

    int deleteByUserId(String userId);
}