package com.web.service;

import com.web.model.ProductPriceList;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductPriceService {
    public List<ProductPriceList> likeQuery(String producePriceName);

    public void showPriceByPage(HttpServletRequest request, Model model);

    int deleteByPrimaryKey(Integer priceListId);

    int insert(ProductPriceList record);

    ProductPriceList selectByPrimaryKey(Integer priceListId);

    int updateByPrimaryKey(ProductPriceList record);

    ProductPriceList selectByName(String priceListName);

}
