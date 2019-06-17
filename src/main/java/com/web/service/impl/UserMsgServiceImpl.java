package com.web.service.impl;

import com.web.dao.UserMsgMapper;
import com.web.model.UserMsg;
import com.web.model.UserMsgExample;
import com.web.service.UserMsgService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserMsgServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 11:04
 **/
@Service
public class UserMsgServiceImpl implements UserMsgService {
    @Autowired
    private UserMsgMapper userMsgMapper;

    @Override
    public int insert(UserMsg record) {
        return userMsgMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer userMsgId) {
        return userMsgMapper.deleteByPrimaryKey(userMsgId);
    }

    @Override
    public UserMsg selectByPrimaryKey(Integer userMsgId) {
        return userMsgMapper.selectByPrimaryKey(userMsgId);
    }

    @Override
    public int updateByPrimaryKey(UserMsg record) {
        return userMsgMapper.updateByPrimaryKey(record);
    }
    @Override
    public void showUserMsgByPage(HttpServletRequest request, Model model) {
        // TODO Auto-generated method stub
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<UserMsg> userMsgList = new ArrayList<UserMsg>();
        //查询用户总数
        int totalCount = (int) userMsgMapper.getUserMsgCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            userMsgList = this.userMsgMapper.selectUserMsgByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            userMsgList = this.userMsgMapper.selectUserMsgByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("userMsgList", userMsgList);
        model.addAttribute("page", page);
    }

    @Override
    public int deleteByUserId(String userId) {
        return userMsgMapper.deleteByUserId(userId);
    }


    @Override
    public List<UserMsg> likeQuery(String userProHobby) {
        return userMsgMapper.likeQuery(userProHobby);
    }

}
