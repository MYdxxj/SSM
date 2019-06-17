package com.web.service.impl;

import com.web.dao.ProductPriceListMapper;
import com.web.model.ProductPriceList;
import com.web.service.ProductPriceService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductPriceServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/18 11:30
 **/
@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private ProductPriceListMapper productPriceDao;

    @Override
    public List<ProductPriceList> likeQuery(String producePriceName) {
        return productPriceDao.likeQuery(producePriceName);
    }

    @Override
    public void showPriceByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<ProductPriceList> productPrices = new ArrayList<ProductPriceList>();
        //查询用户总数
        int totalCount = (int) productPriceDao.getPriceCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            productPrices = this.productPriceDao.selectPriceByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            productPrices = this.productPriceDao.selectPriceByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("productPrices", productPrices);
        model.addAttribute("page", page);
    }

    @Override
    public int deleteByPrimaryKey(Integer priceListId) {
        return productPriceDao.deleteByPrimaryKey(priceListId);
    }

    @Override
    public int insert(ProductPriceList record) {
        return productPriceDao.insert(record);
    }

    @Override
    public ProductPriceList selectByPrimaryKey(Integer priceListId) {
        return productPriceDao.selectByPrimaryKey(priceListId);
    }

    @Override
    public int updateByPrimaryKey(ProductPriceList record) {
        return productPriceDao.updateByPrimaryKey(record);
    }

    @Override
    public ProductPriceList selectByName(String priceListName) {
        return productPriceDao.selectByName(priceListName);
    }

}
