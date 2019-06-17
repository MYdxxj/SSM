package com.web.controller.system;

import com.web.model.Role;
import com.web.model.User;
import com.web.model.UserRole;
import com.web.service.RoleService;
import com.web.service.UserRoleService;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program:product
 * @description:角色用户
 * @author:YangXiaoJiao
 * @create:2019-01-24 18:02
 **/
@Controller
@RequestMapping(value = "userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    /**
     *@Description:取得用户的角色
     *@Author:YangXiaoJiao
     *@Date:17:56 2019/1/24
     *@return:
     **/
    @RequestMapping(value="getUserRole")
    public String getUserRole(Long userId, Model model){
        try{
            if(userId!=null){
                User user = userService.selectByPrimaryKey(userId);
                List<Role> userRoles = roleService.getUserRoleByUserId(userId);
                List<Role> roles = roleService.selectAllRole();
                if(userRoles.size()>0){
                    model.addAttribute("userRoles",userRoles);
                }else{
                    model.addAttribute("noUser","当前用户还没有选定角色");
                }
                model.addAttribute("user",user);
                model.addAttribute("roles",roles);
            }

        }catch(Exception e){
            e.getMessage();
        }
        return "/view/system/user/userRole";
    }
    @RequestMapping(value="saveUserRole")
    public String saveUserRole(Long[] roleIds,Long userId){
        System.out.println("userId ==="+userId);
        UserRole userRole = new UserRole();
        if(userId!=null){
            userRoleService.deleteByPrimaryKey1(userId);
            System.out.println("删除成功");
        }
        if(roleIds.length!=0){
            for (Long roleId : roleIds) {
                userRole.setRoleId(roleId);
                userRole.setUserId(userId);
                userRoleService.insert(userRole);
                System.out.println("插入成功");
            }
        }
        return "redirect:/user/pageList";
    }
}
