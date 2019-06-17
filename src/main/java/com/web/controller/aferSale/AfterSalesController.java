package com.web.controller.aferSale;

import com.web.model.AfterSales;
import com.web.model.Order;
import com.web.model.User;
import com.web.service.AfterSalesService;
import com.web.service.OrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AfterSalesController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 16:04
 **/
@Controller
@RequestMapping("afterSales")
public class AfterSalesController {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private AfterSalesService afterSalesService;
    @Autowired
    private OrderService orderService;
/*
 *@Author: 杨小姣
 *@Description: 分页查找
 *@Date: 16:07 2019/2/19
 **/
    @RequestMapping("/pageList")
    public String pagingAfterSales(HttpServletRequest request, Model model){
        afterSalesService.showAfterSalesByPage(request, model);
        return "view/afterSale/afterSales/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除
     *@Date: 16:08 2019/2/19
     **/
    @RequestMapping(value="delete")
    public String deleteAfterSales(Integer afterSalesId){
        try{
            if(afterSalesId!=null){
                int i = afterSalesService.deleteByPrimaryKey(afterSalesId);
                if (i>0){
                    System.out.println("删除售后信息成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/afterSales/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:44 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllAfterSales(String text){
        try{
            String[] afterSalesIds = text.split(",");
            for (String afterSalesId : afterSalesIds) {
                afterSalesService.deleteByPrimaryKey(Integer.valueOf(afterSalesId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/afterSales/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改
     *@Date: 17:44 2019/2/26
     **/
    @RequestMapping(value="/update")
    public String update(String afterSalesId, String orderInformation, String waiterId, String afterSalesDsc){
        Integer aId = Integer.valueOf(afterSalesId);
        try{
            AfterSales afterSales = afterSalesService.selectByPrimaryKey(aId);
            if(afterSales!=null){
                afterSales.setOrderInformation(orderInformation);
                afterSales.setWaiterId(waiterId);
                afterSales.setAfterSalesDsc(afterSalesDsc);
                int i = afterSalesService.updateByPrimaryKey(afterSales);
                if(i>0){
                    System.out.println("删除售后信息成功");
                }
            }
        }catch(Exception e){e.printStackTrace();}
        return "redirect:/afterSales/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 新增
     *@Date: 16:20 2019/2/19
     **/
    @RequestMapping(value="/newAfterSales")
    public String newAfterSales(AfterSales afterSales){
        try{
           if(afterSales!=null){
               afterSales.setAfterSalesCreateTime(Timestamp.valueOf(sdf.format(new Date())));
               int i = afterSalesService.insert(afterSales);
               if(i>0){
                   System.out.println("新增售后信息成功");
               }
           }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增用户订单异常");
        }
        return "redirect:/afterSales/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 个人售后订单
     *@Date: 15:51 2019/2/25
     **/
    @RequestMapping("personOrder")
    public  String personAfter( Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try{
            List<Order> orders = orderService.selectByUserId(String.valueOf(user.getUserId()));
            List<AfterSales> afterSalesList = new ArrayList<AfterSales>();
            for (Order order : orders) {
                List<AfterSales> aS = afterSalesService.selectAllByOrderId(String.valueOf(order.getOrderId()));
                if(aS.size()!=0){
                    afterSalesList.addAll(aS);
                }
            }
            model.addAttribute("afterSalesList",afterSalesList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "view/afterSale/orderFeedback/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除
     *@Date: 16:08 2019/2/19
     **/
    @RequestMapping(value="deletePersonOrder")
    public String deletePersonOrder(Integer afterSalesId){
        try{
            if(afterSalesId!=null){
                int i = afterSalesService.deleteByPrimaryKey(afterSalesId);
                if (i>0){
                    System.out.println("删除售后信息成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/afterSales/personOrder";
    }/*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:47 2019/2/26
     **/
    @RequestMapping(value="deleteAllPersonOrder")
    public String deleteAllRole(String text){
        try{
            String[] afterSalesIds = text.split(",");
            for (String afterSalesId : afterSalesIds) {
                afterSalesService.deleteByPrimaryKey(Integer.valueOf(afterSalesId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return"redirect:/afterSales/personOrder";
    }
}
