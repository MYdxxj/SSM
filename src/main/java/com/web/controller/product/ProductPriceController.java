package com.web.controller.product;

import com.alibaba.fastjson.JSON;
import com.web.model.ProductCollect;
import com.web.model.ProductPriceList;
import com.web.service.ProductCollectService;
import com.web.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ProductPriceController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/18 11:24
 **/
@Controller
@RequestMapping("productPrice")
public class ProductPriceController {
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private ProductCollectService productCollectService;
    /*
     *@Author: 杨小姣
     *@Description: list
     *@Date: 11:56 2019/2/18
     **/
    @RequestMapping("/pageList")
    public String pagingProductPrice(HttpServletRequest request, Model model){
        productPriceService.showPriceByPage(request, model);
        return "view/product/productPrice/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除产品价格
     *@Date: 11:58 2019/2/18
     **/
    @RequestMapping(value="delete")
    public String deleteProducePrice(Integer priceListId){
        try{
            if(priceListId!=null){
                int i = productPriceService.deleteByPrimaryKey(priceListId);
                int i1 = productCollectService.deleteByProductId(priceListId);
                if (i>0 && i1>0){
                    System.out.println("删除产品成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/productPrice/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:26 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllProducePrice(String text){
        try{
            String[] priceListIds = text.split(",");
            for (String priceListId : priceListIds) {
                productPriceService.deleteByPrimaryKey(Integer.valueOf(priceListId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/productPrice/pageList";
    }

    @RequestMapping(value="/update")
    public String update(String priceListId,String productPriceName,String productListDesc,String productUnitPrice,String productSellingPrice ,String productSourceCompany,String productRemark){
        Integer pId = Integer.valueOf(priceListId);
        ProductPriceList productPrice = productPriceService.selectByPrimaryKey(pId);
        productPrice.setProductPriceName(productPriceName);
        productPrice.setProductListDesc(productListDesc);
        productPrice.setProductUnitPrice(productUnitPrice);
        productPrice.setProductSellingPrice(productSellingPrice);
        productPrice.setProductSourceCompany(productSourceCompany);
        productPrice.setProductRemark(productRemark);
        int i = productPriceService.updateByPrimaryKey(productPrice);
        if(i>0){
            System.out.println("修改产品报价成功");
        }
        return "redirect:/productPrice/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 新增产品报价单
     *@Date: 17:24 2019/2/18
     **/
    @RequestMapping(value="/newProductPrice")
    public String newProductPrice(ProductPriceList PriceList){
        try{
            if(PriceList!=null) {
                PriceList.setProductListCreatetime(Timestamp.valueOf(sdf2.format(new Date())));
                int i = productPriceService.insert(PriceList);
                ProductPriceList product = productPriceService.selectByName(PriceList.getProductPriceName());
                ProductCollect productCollect = new ProductCollect();
                productCollect.setMarketTime(product.getProductListCreatetime());
                productCollect.setProductPriceListId(product.getPriceListId());
                productCollect.setProductName(product.getProductPriceName());
                productCollect.setProductType(product.getProductListDesc());
                int insert = productCollectService.insert(productCollect);

                if (i > 0 && insert>0) {
                    System.out.println("产品报价单新增成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增产品报价单异常");
        }
        return "redirect:/productPrice/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 模糊查询
     *@Date: 9:14 2019/2/19
     **/
    @RequestMapping(value="/likeSearch")
    @ResponseBody
    public String likeSearch(String productInput){
        try{
            List<ProductPriceList> productPrices = productPriceService.likeQuery(productInput);
            return JSON.toJSONString(productPrices);
        }catch(Exception e){
            return "用户查找失败";
        }
    }
}
