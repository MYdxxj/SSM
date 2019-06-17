package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program:product
 * @description:页面跳转
 * @author:YangXiaoJiao
 * @create:2019-01-16 14:12
 **/
@Controller
@RequestMapping
public class BaseController {
    @RequestMapping("user")
    public String User(){
        return"main/admin-user";
    }
    @RequestMapping("table")
    public String table(){
        return "main/admin-user";
    }
    @RequestMapping("log")
    public String log(){
        return "main/admin-log";
    }
    @RequestMapping("index")
    public String index(){
        return "main/admin-index";
    }
    @RequestMapping("help")
    public String help(){
        return "main/admin-help";
    }
     @RequestMapping("unfound")
    public String unfound(){
        return "main/admin-404";
    }
    @RequestMapping("main")
    public String main(){
        return "main/index";
    }
    @RequestMapping("/tologin")
    public String hello(){
        return "/login";
    }
    @RequestMapping("userList")
    public String userList(){
        return "/view/system/user/list";
    }

    @RequestMapping("menuList")
    public String menuList(){
        return "/view/system/menu/list";
    }

    @RequestMapping(value = "roleList")
    public String roleList(){
        return "/view/system/role/list";
    }
    @RequestMapping("first")
    public String first(){
        return "main/main";
    }
    @RequestMapping("technology")
    public String technology(){
        return "view/afterSale/technology/list";
    }
    @RequestMapping("register")
    public String register(){return "register";

    }

}
