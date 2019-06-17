package com.web.service;

import com.web.model.ProductCollect;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface ProductCollectService {
    public void showProductCollectByPage(HttpServletRequest request, Model model);

    int insert(ProductCollect record);

    int deleteByProductId(Integer productId);
}
