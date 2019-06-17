package com.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.web.model.Role;
import com.web.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program:product
 * @description:角色管理
 * @author:YangXiaoJiao
 * @create:2019-01-21 09:16
 **/
@Controller
@RequestMapping(value="role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    /**
    *@Description:角色List
    *@Author:YangXiaoJiao
    *@Date:15:31 2019/1/23
    **/
   /* @RequestMapping(value="/list")
    @ResponseBody
    public String roleList(){
        try{
            List<Role> roleList = roleService.selectAllRole();
            return JSON.toJSONString(roleList);
        }catch(Exception e){
            return "角色查找失败";
        }
    }*/
    @RequestMapping("/pageList")
    public String pagingRole(HttpServletRequest request, Model model){
        roleService.showRoleByPage(request, model);
        return "view/system/role/list";
    }
    /**
    *@Description:角色删除
    *@Author:YangXiaoJiao
    *@Date:15:31 2019/1/23
    **/
    @RequestMapping(value="delete")
    public String deleteRole(Long roleId){
        try{
            if(roleId!=null){
                int i = roleService.deleteByPrimaryKey(roleId);
                if (i>0){
                    System.out.println("删除成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/role/pageList";
    }
/*
 *@Author: 杨小姣
 *@Description: 批量删除
 *@Date: 16:03 2019/2/26
 **/
    @RequestMapping(value="deleteAll")
    public String deleteAllRole(String text){
        try{
            String[] roleIds = text.split(",");
            for (String roleId : roleIds) {
                roleService.deleteByPrimaryKey(Long.valueOf(roleId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/role/pageList";
    }
    /**
    *@Description:修改
    *@Author:YangXiaoJiao
    *@Date:15:32 2019/1/23
    **/
    @RequestMapping(value="/update")
    public String update(String roleId,String roleName,String roleDesc,String roleState){
        try {
            Long rId = Long.valueOf(roleId);
            Role role = roleService.selectByPrimaryKey(rId);
            role.setRoleName(roleName);
            role.setRoleDesc(roleDesc);
            role.setRoleState(roleState);
            int i = roleService.updateByPrimaryKey(role);
            if(i>0){
                System.out.println("修改成功");
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("修改失败");
        }
        return "redirect:/role/pageList";
    }
    /**
    *@Description:新增角色
    *@Author:YangXiaoJiao
    *@Date:15:33 2019/1/23
    **/
    @RequestMapping(value="/newRole")
    public String newRole(String roleName,String roleDesc,String roleState){
        try{
            Role role = new Role();
            role.setRoleName(roleName);
            role.setRoleDesc(roleDesc);
            role.setRoleState(roleState);
            int i = roleService.insert(role);
            if(i > 0){
                System.out.println("新增角色成功");
            }else{
                System.out.println("新增菜单失败");
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增角色异常");
        }
        return "redirect:/role/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 模糊查询
     *@Date: 17:09 2019/2/15
     **/
    @RequestMapping(value="/likeSearch")
    @ResponseBody
    public String likeSearch(String roleInput){
        try{
            List<Role> roleList = roleService.likeQuery(roleInput);
            return JSON.toJSONString(roleList);
        }catch(Exception e){
            return "角色查找失败";
        }
    }
}