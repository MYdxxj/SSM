package com.web.service.impl;

import com.web.dao.OrderFeedbackMapper;
import com.web.model.OrderFeedback;
import com.web.model.User;
import com.web.service.FeedbackService;
import com.web.utils.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FeedbackServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 14:18
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private OrderFeedbackMapper orderFeedbackMapper;

    @Override
    public void showFeedbackByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<OrderFeedback> orderFeedbacks = new ArrayList<>();
        //查询用户总数
        int totalCount = (int) orderFeedbackMapper.getFeedbackCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            orderFeedbacks = this.orderFeedbackMapper.selectFeedbackByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            orderFeedbacks = this.orderFeedbackMapper.selectFeedbackByPage(page.getStartPos(), page.getPageSize());
        }
        model.addAttribute("orderFeedbacks", orderFeedbacks);
        model.addAttribute("page", page);
    }

    @Override
    public List<OrderFeedback> likeQuery(String userInput) {
        return orderFeedbackMapper.likeQuery(userInput);
    }

    @Override
    public int deleteByPrimaryKey(Integer feedbackId) {
        return orderFeedbackMapper.deleteByPrimaryKey(feedbackId);
    }

    @Override
    public int insert(OrderFeedback record) {
        return orderFeedbackMapper.insert(record);
    }

    @Override
    public OrderFeedback selectByPrimaryKey(Integer feedbackId) {
        return orderFeedbackMapper.selectByPrimaryKey(feedbackId);
    }

    @Override
    public int updateByPrimaryKey(OrderFeedback record) {
        return orderFeedbackMapper.updateByPrimaryKey(record);
    }
}
