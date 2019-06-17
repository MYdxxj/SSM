package com.web.service;

import com.web.model.Order;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {

    int deleteByPrimaryKey(Integer orderId);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKey(Order record);

    int insert(Order record);

    void  showOrderByPage(HttpServletRequest request, Model model);

    void  showUserOrderByPage( String userId,HttpServletRequest request, Model model);

    public List<Order> selectByUserId(String userId);
}
