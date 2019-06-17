package com.web.service.impl;

import com.web.dao.ProductCollectMapper;
import com.web.model.ProductCollect;
import com.web.service.ProductCollectService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductCollectServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 9:44
 **/
@Service
public class ProductCollectServiceImpl implements ProductCollectService {
    @Autowired
    private ProductCollectMapper productCollectMapper;
    @Override
    public void showProductCollectByPage(HttpServletRequest request, Model model) {
        // TODO Auto-generated method stub
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<ProductCollect> productCollects = new ArrayList<>();
        //查询用户总数
        int totalCount = (int) productCollectMapper.getProductCollectCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            productCollects = this.productCollectMapper.selectProductCollectByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            productCollects = this.productCollectMapper.selectProductCollectByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("productCollects", productCollects);
        model.addAttribute("page", page);
    }

    @Override
    public int insert(ProductCollect record) {
        return productCollectMapper.insert(record);
    }

    @Override
    public int deleteByProductId(Integer productId) {
        return productCollectMapper.deleteByProductId(productId);
    }
}
