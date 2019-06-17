package com.web.controller.system;

import com.web.model.Menu;
import com.web.model.Role;
import com.web.model.RoleMenu;
import com.web.service.MenuService;
import com.web.service.RoleMenuService;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleMenuController
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/15 9:05
 **/
@Controller
@RequestMapping(value = "roleMenu")
public class RoleMenuController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;
    /*
     *@Author: 杨小姣
     *@Description: 菜单分配
     *@Date: 10:48 2019/2/15
     **/
    @RequestMapping(value="/getRoleMenu")
    public String getRoleMenu(Long roleId, Model model){
        try{
            if(roleId!=null){
                Role role = roleService.selectByPrimaryKey(roleId);
                List<Menu> roleMenus = menuService.getRoleMenuByRoleId(roleId);
                List<Menu> menus = menuService.selectAllMenu();
                if(roleMenus.size()>0){
                    model.addAttribute("roleMenus",roleMenus);
                }else{
                    model.addAttribute("noMenu","此用户还没有选中菜单");
                }
                model.addAttribute("role",role);
                model.addAttribute("menus",menus);
            }

        }catch(Exception e){
            e.getMessage();
        }
        return "view/system/role/roleMenu";
    }
    /*
     *@Author: 杨小姣
     *@Description: 保存角色菜单
     *@Date: 14:44 2019/2/15
     **/
    @RequestMapping(value="/saveRoleMenu")
    public String saveRoleMenu(Long[] menuIds,Long roleId){
        System.out.println("userId ==="+roleId);
        RoleMenu roleMenu = new RoleMenu();
        if(roleId != null){
            roleMenuService.deleteByPrimaryKey1(roleId);
        }
        if(menuIds.length != 0){
            for (Long menuId : menuIds) {
                roleMenu.setMenuId(menuId);
                roleMenu.setRoleId(roleId);
                roleMenuService.insert(roleMenu);
            }
        }
        return "redirect:/role/pageList";
    }
}
