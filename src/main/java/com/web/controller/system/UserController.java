package com.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.web.model.User;
import com.web.model.UserMsg;
import com.web.model.UserRole;
import com.web.service.UserMsgService;
import com.web.service.UserRoleService;
import com.web.service.UserService;
import com.web.utils.GetAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program:product
 * @description:用户管理
 * @author:YangXiaoJiao
 * @create:2019-01-21 09:17
 **/
@Controller
@RequestMapping(value="user")
public class UserController {
    Date d = new Date();
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserMsgService userMsgService;
  /*  @RequestMapping(value="/list")
    @ResponseBody
    public String userList(){
        try{
            List<User> userList = userService.selectAllUser();
            return JSON.toJSONString(userList);

        }catch(Exception e){
            return "用户查找失败";
        }
    }*/
    @RequestMapping("/pageList")
    public String pagingUser(HttpServletRequest request, Model model){
        userService.showUserByPage(request, model);
        return "view/system/user/list";
    }
    /**
     *@Description:
     *@Param:删除
     *@Author:YangXiaoJiao
     *@Date:10:33 2019/1/22
     *@return:null
     **/
    @RequestMapping(value="delete")
    public String deleteUser(Long userId){
        try{
            if(userId!=null){
                int i = userService.deleteByPrimaryKey(userId);
                int k = userRoleService.deleteByPrimaryKey1(userId);
                int i1 = userMsgService.deleteByUserId(String.valueOf(userId));
                if (i>0 && k>0){
                    System.out.println("删除成功");
                }
                if(i1>0){
                    System.out.println("删除用户信息成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/user/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 16:52 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllUser(String text){
        try{
            String[] userIds = text.split(",");
            for (String userId : userIds) {
                userService.deleteByPrimaryKey(Long.valueOf(userId));
                int k = userRoleService.deleteByPrimaryKey1(Long.valueOf(userId));
                int i1 = userMsgService.deleteByUserId(String.valueOf(userId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/user/pageList";
    }
    /**
     *@Description:修改
     *@Author:YangXiaoJiao
     *@Date:11:20 2019/1/22
     **/
    @RequestMapping(value="/update")
    public String update(String userId,String loginName,String userName,String sex,String userPhone){
        Long uId = Long.valueOf(userId);
        User user = userService.selectByPrimaryKey(uId);
        user.setUserName(userName);
        user.setLoginName(loginName);
        user.setUserSex(sex);
        user.setUserPhone(userPhone);
        int i = userService.updateByPrimaryKey(user);
        if(i>0){
            System.out.println("修改成功");
        }
           /* Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(8);
            Date Brithday = formatter.parse(userBrithday, pos);
            user.setUserBirthday(Brithday);*/
        return "redirect:/user/pageList";
    }
    /**
     *@Description:新增用户
     *@Author:YangXiaoJiao
     *@Date:9:25 2019/1/23
     **/
    @RequestMapping(value="/newUser")
    public String newUser(String loginName,String userName, String sex, String userPhone, String userBirthday){
        try{
            User user = new User();
            user.setLoginName(loginName);
            user.setUserName(userName);
            user.setPassword("123456");
            user.setUserSex(sex);
            user.setUserAge(String.valueOf(GetAge.getAgeByBirth(sdf.parse(userBirthday))));
            /*user.setUserAge(userAge);*/
            user.setUserPhone(userPhone);
            userBirthday+=" 00:00:00";
            Date date=sdf2.parse(userBirthday);
            user.setUserBirthday(Timestamp.valueOf(sdf2.format(date)));
            user.setCreateTime(Timestamp.valueOf(sdf2.format(new Date())));
            userService.insert(user);
            //更新到userRole表中
            User u = userService.selectUserByName(loginName);
            UserRole userRole = new UserRole();
            userRole.setUserId(u.getUserId());
            userRole.setRoleId(2l);//新建用户统一默认为普通用户
            userRoleService.insert(userRole);
            //更新到userMsgCollect中
            UserMsg userMsg = new UserMsg();
            userMsg.setUserId(String.valueOf(u.getUserId()));
            userMsg.setUserAge(u.getUserAge());
            userMsg.setUserSex(u.getUserSex());
            userMsgService.insert(userMsg);
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增用户异常");
        }
        return "redirect:/user/pageList";
    }
/*
 *@Author: 杨小姣
 *@Description: 模糊查询
 *@Date: 17:09 2019/2/15
 **/
    @RequestMapping(value="/likeSearch")
    @ResponseBody
    public String likeSearch(String userInput){
        try{
            List<User> userList = userService.likeQuery(userInput);
            for (User user : userList) {
                System.out.println(user.getUserName());
            }
            return JSON.toJSONString(userList);
        }catch(Exception e){
            return "用户查找失败";
        }
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改密码
     *@Date: 9:44 2019/2/21
     **/
    @RequestMapping("setPassword")
    @ResponseBody
    public String setPassword(String userId,String newPassword){
        try{
            User user = userService.selectByPrimaryKey(Long.valueOf(userId));
            user.setPassword(newPassword);
            int i = userService.updateByPrimaryKey(user);
           if (i>0){
               System.out.println("修改密码成功");
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString("修改密码成功");
    }
    /*
     * @Author 杨小姣
     * @Description 注册
     * @Date 17:51 2019/3/15
     **/
    @RequestMapping("/tologin")
    public String registerUser(String username,String password,String sex){
        try{
            User user = new User();
            user.setLoginName(username);
            user.setUserName(username);
            user.setPassword(password);
            user.setUserPhone(username);
            user.setUserSex(sex);
            user.setCreateTime(Timestamp.valueOf(sdf2.format(new Date())));
            int insert = userService.insert(user);
            //更新到userRole表中
            User u = userService.selectUserByName(username);
            UserRole userRole = new UserRole();
            userRole.setUserId(u.getUserId());
            userRole.setRoleId(2l);//新建用户统一默认为普通用户
            userRoleService.insert(userRole);
            //更新到userMsgCollect中
            UserMsg userMsg = new UserMsg();
            userMsg.setUserId(String.valueOf(u.getUserId()));
            userMsg.setUserAge(u.getUserAge());
            userMsg.setUserSex(u.getUserSex());
            userMsg.setUserPhone(u.getUserPhone());
            userMsgService.insert(userMsg);

            if(insert>0){
                System.out.println("用户注册成功！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return "login";
    }

}
