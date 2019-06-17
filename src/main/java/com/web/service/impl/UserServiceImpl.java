package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.web.dao.UserDao;
import com.web.model.User;
import com.web.service.UserService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:product
 * @description:
 * @author:YangXiaoJiao
 * @create:2019-01-15 11:12
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByName(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public User selectByPrimaryKey(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public void showUserByPage(HttpServletRequest request, Model model) {
        // TODO Auto-generated method stub
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<User> userList = new ArrayList<User>();
        //查询用户总数
        int totalCount = (int) userDao.getUserCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            userList = this.userDao.selectUserByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            userList = this.userDao.selectUserByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("userList", userList);
        model.addAttribute("page", page);
    }

    @Override
    public List<User> likeQuery(String userInput) {
        return userDao.likeQuery(userInput);
    }


}
