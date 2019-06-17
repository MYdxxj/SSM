package com.web.controller.product;

import com.web.model.Activity;
import com.web.model.Order;
import com.web.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName ActivityController
 * @Description 活动测试模块
 * Author 杨小姣
 * @Date 2019/2/18 15:42
 **/
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    /*
     *@Author: 杨小姣
     *@Description: 活动查找
     *@Date: 15:58 2019/2/18
     **/
    @RequestMapping("/pageList")
    public String pagingOrder(HttpServletRequest request, Model model){
        activityService.showActivityByPage(request, model);
        return "view/product/activity/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除活动
     *@Date: 15:59 2019/2/18
     **/
    @RequestMapping(value="delete")
    public String deleteActivity(Integer activityId){
        try{
            if(activityId!=null){
                int i = activityService.deleteByPrimaryKey(activityId);
                if (i>0){
                    System.out.println("删除订单成功");
                }

            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/activity/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 17:19 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllActivity(String text){
        try{
            String[] activityIds = text.split(",");
            for (String activityId : activityIds) {
                activityService.deleteByPrimaryKey(Integer.valueOf(activityId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/activity/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改活动
     *@Date: 16:00 2019/2/18
     **/
    @RequestMapping(value="/update")
    public String update(String activityId,String activityName,String activityType,String activityStatus,String activityDescription ,String activityTime){
        Integer aId = Integer.valueOf(activityId);
        Activity activity = activityService.selectByPrimaryKey(aId);
        activity.setActivityName(activityName);
        activity.setActivityType(activityType);
        activity.setActivityStatus(activityStatus);
        activity.setActivityDescription(activityDescription);
        activity.setActivityTime(activityTime);
        int i = activityService.updateByPrimaryKey(activity);
        if(i>0){
            System.out.println("修改活动成功");
        }
        return "redirect:/activity/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 新增活动
     *@Date: 17:17 2019/2/18
     **/
    @RequestMapping(value="/newActivity")
    public String newActivity(String activityName,String activityType,String activityStatus,String activityDescription ,String activityTime){
        try{
            Activity activity = new Activity();
            activity.setActivityName(activityName);
            activity.setActivityType(activityType);
            activity.setActivityStatus(activityStatus);
            activity.setActivityDescription(activityDescription);
            activity.setActivityTime(activityTime);
            activityService.insert(activity);
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增活动异常");
        }
        return "redirect:/activity/pageList";
    }
}
