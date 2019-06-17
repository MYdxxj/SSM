package com.web.service;

import com.web.model.UserMsg;
import com.web.model.UserMsgExample;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserMsgService {

    int insert(UserMsg record);

    int deleteByPrimaryKey(Integer userMsgId);

    UserMsg selectByPrimaryKey(Integer userMsgId);

    int updateByPrimaryKey(UserMsg record);

    public List<UserMsg> likeQuery(String userProHobby);

    public void showUserMsgByPage(HttpServletRequest request, Model model);

    int deleteByUserId(String userId);
}
