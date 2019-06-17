package com.web.service;

import com.web.model.AfterSales;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface AfterSalesService  {
    public List<AfterSales> likeQuery(String orderInformation);

    int insert(AfterSales record);

    int deleteByPrimaryKey(Integer afterSalesId);

    AfterSales selectByPrimaryKey(Integer afterSalesId);

    int updateByPrimaryKey(AfterSales record);

    void  showAfterSalesByPage(HttpServletRequest request, Model model);

    void  showAfterSalesByPage( String orderId,HttpServletRequest request, Model model);

    List<AfterSales> selectAllByOrderId(String OrderId);
}
