package com.web.controller.product;

import com.web.model.*;
import com.web.service.AfterSalesService;
import com.web.service.OrderService;
import com.web.service.ProductCollectService;
import com.web.service.ProductPriceService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName OrderController
 * @Description 用户订单管理
 * Author 杨小姣
 * @Date 2019/2/18 14:15
 **/
@Controller
@RequestMapping("order")
public class OrderController {
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private AfterSalesService afterSalesService;
    /*
     *@Author: 杨小姣
     *@Description: 查找
     *@Date: 14:56 2019/2/18
     **/
    @RequestMapping("/pageList")
    public String pagingOrder(HttpServletRequest request, Model model){
        orderService.showOrderByPage(request, model);
        return "view/product/order/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除订单
     *@Date: 15:00 2019/2/18
     **/
    @RequestMapping(value="delete")
    public String deleteOrder(Integer orderId){
        try{
            if(orderId!=null){
                int i = orderService.deleteByPrimaryKey(orderId);
                if (i>0){
                    System.out.println("删除订单成功");
                }

            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/order/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:19 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllOrder(String text){
        try{
            String[] orderIds = text.split(",");
            for (String orderId : orderIds) {
                orderService.deleteByPrimaryKey(Integer.valueOf(orderId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/order/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改订单
     *@Date: 15:08 2019/2/18
     **/
    @RequestMapping(value="/update")
    public String update(String orderId,String orderType,String orderState,String userId,String orderTotal){
        Integer oId = Integer.valueOf(orderId);
        Order order = orderService.selectByPrimaryKey(oId);
        order.setOrderType(orderType);
        order.setOrderState(orderState);
        order.setUserId(userId);
        order.setOrderTotal(orderTotal);
        int i = orderService.updateByPrimaryKey(order);
        if(i>0){
            System.out.println("修改成功");
        }
        return "redirect:/order/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 新增订单
     *@Date: 16:08 2019/2/18
     **/
    @RequestMapping(value="/newOrder")
    public String newOrder(String orderType,String orderState,String userId,String orderDesc,String orderTotal){
        try{
            Order order = new Order();
            order.setOrderType(orderType);
            order.setOrderState(orderState);
            order.setUserId(userId);
            order.setOrderDesc(orderDesc);
            order.setOrderTotal(orderTotal);
            order.setOrderCreatetime(Timestamp.valueOf(sdf2.format(new Date())));
            orderService.insert(order);
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增用户订单异常");
        }
        return "redirect:/order/pageList";
    }
    @RequestMapping("purchase")
    public String purchase(String priceId,String price,String number){
        try{
            ProductPriceList productPrice = productPriceService.selectByPrimaryKey(Integer.valueOf(priceId));
            Order order = new Order();
            order.setOrderType("网购");
            order.setOrderState("已付款");
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            order.setUserId(String.valueOf(user.getUserId()));
            order.setOrderDesc(productPrice.getProductPriceName());
            float total =  Float.valueOf(price) * Float.valueOf(number);
            order.setOrderTotal(String.valueOf(total));
            order.setOrderCreatetime(Timestamp.valueOf(sdf2.format(new Date())));
            orderService.insert(order);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/productPrice/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:19 2019/2/26
     **/
    @RequestMapping(value="deleteAllPerson")
    public String deleteAllPerson(String text){
        try{
            String[] orderIds = text.split(",");
            for (String orderId : orderIds) {
                orderService.deleteByPrimaryKey(Integer.valueOf(orderId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/order/personOrder";
    }
    /*
     *@Author: 杨小姣
     *@Description: 退款
     *@Date: 17:43 2019/2/21
     **/
    @RequestMapping("refund")
    public String refund(Integer orderId ){
        Order order = orderService.selectByPrimaryKey(orderId);
        order.setOrderState("退款中");
        orderService.updateByPrimaryKey(order);
        return "redirect:/order/pageList";
    }
    @RequestMapping("userRefund")
    public String userRefund(Integer orderId ){
        Order order = orderService.selectByPrimaryKey(orderId);
        order.setOrderState("退款中");
        orderService.updateByPrimaryKey(order);
        return "redirect:/order/personOrder";
    }

    /*
     *@Author: 杨小姣
     *@Description: 查询个人订单
     *@Date: 14:20 2019/2/25
     **/
    @RequestMapping("personOrder")
    public  String personOrder(HttpServletRequest request, Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        orderService.showUserOrderByPage(String.valueOf(user.getUserId()),request, model);
        return "view/product/personOrder/list";
    }
    @RequestMapping("createSales")
    public String createSales( Integer orderId,String pictureUrl,int sum,String access){
        try{
            Order order = orderService.selectByPrimaryKey(orderId);
            AfterSales afterSales = new AfterSales();
            afterSales.setAfterSalesCreateTime(Timestamp.valueOf(sdf2.format(new Date())));
            afterSales.setOrderInformation(String.valueOf(orderId));
            afterSales.setWaiterId(pictureUrl.replace(","," "));
            if(sum==1){
                access="很不好（"+access+"）";
            }else if(sum == 2){
                access="不好（"+access+"）";
            }else if(sum == 3){
                access="一般（"+access+"）";
            }else if(sum ==4){
                access="很好（"+access+"）";
            }else{
                access="非常好（"+access+"）";
            }
            afterSales.setAfterSalesDsc(access);
            afterSales.setAfterSalesDsc(access);
            afterSalesService.insert(afterSales);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/order/personOrder";
    }


}
