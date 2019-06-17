package com.web.controller.product;

import com.web.service.ProductCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ProductCollectController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 9:46
 **/
@Controller
@RequestMapping("productCollect")
public class ProductCollectController {
    @Autowired
    private ProductCollectService productCollectService;
    @RequestMapping("/pageList")
    public String pagingProductCollect(HttpServletRequest request, Model model){
        productCollectService.showProductCollectByPage(request, model);
        return "view/product/productCollect/list";
    }
}
