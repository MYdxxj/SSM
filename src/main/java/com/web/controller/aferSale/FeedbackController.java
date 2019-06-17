package com.web.controller.aferSale;

import com.web.dao.OrderFeedbackMapper;
import com.web.model.*;
import com.web.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FeedbackController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 14:42
 **/
@Controller
@RequestMapping("feedback")
public class FeedbackController {
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private AfterSalesService afterSalesService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoleService roleService;
    /*
     *@Author: 杨小姣
     *@Description: 查找
     *@Date: 14:43 2019/2/19
     **/
    @RequestMapping("/pageList")
    public String pagingFeedback(HttpServletRequest request, Model model){
        feedbackService.showFeedbackByPage(request, model);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        List<Role> roles = roleService.getUserRoleByUserId(user.getUserId());
        for (Role role : roles) {
            System.out.println(role.getRoleName());
        }
        model.addAttribute("roles",roles);
        return "view/afterSale/feedback/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除
     *@Date: 14:45 2019/2/19
     **/
    @RequestMapping(value="delete")
    public String deleteFeedback(Integer feedbackId){
        try{
            if(feedbackId!=null){
                int i = feedbackService.deleteByPrimaryKey(feedbackId);
                if (i>0){
                    System.out.println("删除反馈信息成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/feedback/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 处理反馈
     *@Date: 16:09 2019/2/19
     **/
    @RequestMapping("handle")
    public String handle(Integer feedbackId){
    try{
        if(feedbackId!=null){
            OrderFeedback orderFeedback = feedbackService.selectByPrimaryKey(feedbackId);
            if(orderFeedback!=null){
                orderFeedback.setHandleStatus("正在处理中");
                int i = feedbackService.updateByPrimaryKey(orderFeedback);
                if(i>0){
                    System.out.println("处理成功");
                }
            }
        }
    }catch(Exception e ){
        e.printStackTrace();
    }
        return "redirect:/feedback/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:48 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllRole(String text){
        try{
            String[] feedbackIds = text.split(",");
            for (String feedbackId : feedbackIds) {
                feedbackService.deleteByPrimaryKey(Integer.valueOf(feedbackId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/feedback/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 增加反馈信息
     *@Date: 18:42 2019/2/25
     **/
    @RequestMapping("userFeedback")
    public String userFeedback(String afterSalesId,String question){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        OrderFeedback orderFeedback = new OrderFeedback();
        orderFeedback.setFeedbackCreatetime(Timestamp.valueOf(sdf2.format(new Date())));
        orderFeedback.setUserName(user.getUserName());
        orderFeedback.setUserSex(user.getUserSex());
        orderFeedback.setProductProblem(question);
        orderFeedback.setHandleStatus("未处理");
        orderFeedback.setUserContact(user.getUserPhone());
        AfterSales afterSales = afterSalesService.selectByPrimaryKey(Integer.valueOf(afterSalesId));
        Order order = orderService.selectByPrimaryKey(Integer.valueOf(afterSales.getOrderInformation()));
        orderFeedback.setProductName(order.getOrderDesc());
        orderFeedback.setProductBuydate(sdf.format(order.getOrderCreatetime()));
        feedbackService.insert(orderFeedback);
        return "redirect:/afterSales/personOrder";
    }
    /*
     *@Author: 杨小姣
     *@Description: 管理员解决用户反馈问题
     *@Date: 9:31 2019/2/26
     **/
    @RequestMapping("solved")
    public String solved(String feedbackId){
        OrderFeedback orderFeedback = feedbackService.selectByPrimaryKey(Integer.valueOf(feedbackId));
        orderFeedback.setHandleStatus("已解决");
        int i = feedbackService.updateByPrimaryKey(orderFeedback);
        if(i>0){
            System.out.println("更新成功");
        }
        return "redirect:/feedback/pageList";
    }
}
