package com.web.controller.product;

import com.web.model.UserMsg;
import com.web.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserMsgController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/19 11:19
 **/
@Controller
@RequestMapping("userMsg")
public class UserMsgController {
    @Autowired
    private UserMsgService userMsgService;
    /*
     *@Author: 杨小姣
     *@Description: 查看
     *@Date: 11:21 2019/2/19
     **/
    @RequestMapping("/pageList")
    public String pagingUserMsg(HttpServletRequest request, Model model){
        userMsgService.showUserMsgByPage(request, model);
        return "view/product/userMsg/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除
     *@Date: 11:21 2019/2/19
     **/
    @RequestMapping(value="delete")
    public String deleteUserMsg(Integer userMsgId){
        try{
            if(userMsgId!=null){
                int i = userMsgService.deleteByPrimaryKey(userMsgId);
                if (i>0){
                    System.out.println("删除成功");
                }

            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/userMsg/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改
     *@Date: 11:23 2019/2/19
     **/
    @RequestMapping(value="/update")
    public String update(String userMsgId, String userAge, String userSex, String userEmail, String userPhone, String userProHobby ,HttpServletRequest request){
        try{
            String province=request.getParameter("pro");
            String city=request.getParameter("city");
            UserMsg userMsg = userMsgService.selectByPrimaryKey(Integer.valueOf(userMsgId));
            if(userMsg!=null){
                userMsg.setUserAge(userAge);
                userMsg.setUserSex(userSex);
                userMsg.setUserEmail(userEmail);
                userMsg.setUserPhone(userPhone);
                userMsg.setUserAddr(province+","+city);
               /* userMsg.setUserAddr(userAddr);*/
                userMsg.setUserProHobby(userProHobby);
                int i = userMsgService.updateByPrimaryKey(userMsg);
                if(i>0){
                    System.out.println("修改成功");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/userMsg/pageList";
    }
/*
 *@Author: 杨小姣
 *@Description: 新增用户信息收集
 *@Date: 11:35 2019/2/19
 **/
    @RequestMapping(value="/newUserMsg")
    public String newUserMsg(UserMsg userMsg){
        try{
            if(userMsg!=null) {
                int i = userMsgService.insert(userMsg);
                if (i > 0) {
                    System.out.println("新增用户信息收集成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增用户信息收集异常");
        }
        return "redirect:/userMsg/pageList";
    }
}
