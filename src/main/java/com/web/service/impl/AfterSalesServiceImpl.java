package com.web.service.impl;

import com.web.dao.AfterSalesMapper;
import com.web.model.AfterSales;
import com.web.service.AfterSalesService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AfterSalesServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 15:53
 **/
@Service
public class AfterSalesServiceImpl implements AfterSalesService {

    @Autowired
    private AfterSalesMapper afterSalesMapper;

    @Override
    public List<AfterSales> likeQuery(String orderInformation) {
        return afterSalesMapper.likeQuery(orderInformation);
    }

    @Override
    public int insert(AfterSales record) {
        return afterSalesMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer afterSalesId) {
        return afterSalesMapper.deleteByPrimaryKey(afterSalesId);
    }

    @Override
    public AfterSales selectByPrimaryKey(Integer afterSalesId) {
        return afterSalesMapper.selectByPrimaryKey(afterSalesId);
    }

    @Override
    public int updateByPrimaryKey(AfterSales record) {
        return afterSalesMapper.updateByPrimaryKey(record);
    }

    @Override
    public void showAfterSalesByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<AfterSales> afterSalesList = new ArrayList<AfterSales>();
        //查询用户总数
        int totalCount = (int) afterSalesMapper.getAfterSalesCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            afterSalesList = this.afterSalesMapper.selectAfterSalesByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            afterSalesList = this.afterSalesMapper.selectAfterSalesByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("afterSalesList", afterSalesList);
        model.addAttribute("page", page);
    }

    @Override
    public void showAfterSalesByPage(String orderId, HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<AfterSales> afterSalesList = new ArrayList<AfterSales>();
        //查询用户总数
        int totalCount = (int) afterSalesMapper.getAfterSaleCountByOrderId(orderId);

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            afterSalesList = this.afterSalesMapper.selectAfterSaleByOrderId(orderId,page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            afterSalesList = this.afterSalesMapper.selectAfterSaleByOrderId(orderId,page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("afterSales", afterSalesList);
        model.addAttribute("page", page);
    }

    @Override
    public List<AfterSales> selectAllByOrderId(String OrderId) {
        return afterSalesMapper.selectAllByOrderId(OrderId);
    }
}
