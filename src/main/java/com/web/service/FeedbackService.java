package com.web.service;

import com.web.model.OrderFeedback;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FeedbackService {

    void  showFeedbackByPage(HttpServletRequest request, Model model);

    public List<OrderFeedback> likeQuery(String userInput);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(OrderFeedback record);

    OrderFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKey(OrderFeedback record);

}
