package com.web.service.impl;

import com.web.dao.OrderMapper;
import com.web.model.Order;
import com.web.service.OrderService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/18 14:08
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void showOrderByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Order> orderList = new ArrayList<Order>();
        //查询用户总数
        int totalCount = (int) orderMapper.getOrderCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            orderList = this.orderMapper.selectOrderByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            orderList = this.orderMapper.selectOrderByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("orderList", orderList);
        model.addAttribute("page", page);
    }

    @Override
    public void showUserOrderByPage(String userId, HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<Order> orderList = new ArrayList<Order>();
        //查询用户总数
        int totalCount = (int) orderMapper.getUserOrderCount(userId);

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            orderList = this.orderMapper.selectOrderByUserId(userId,page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            orderList = this.orderMapper.selectOrderByUserId(userId,page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("orderList", orderList);
        model.addAttribute("page", page);
    }

    @Override
    public List<Order> selectByUserId(String userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }
}
