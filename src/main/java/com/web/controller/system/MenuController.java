package com.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.web.model.Menu;
import com.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @description:菜单管理
 * @author:YangXiaoJiao
 * @create:2019-01-21 09:17
 **/
@Controller
@RequestMapping(value="menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /*
     *@Author: 杨小姣
     *@Description: 菜单list
     *@Date: 14:21 2019/1/23
     **/
    @RequestMapping(value="/list")
    @ResponseBody
    public String menuList()
    {
        try{
            List<Menu> menuList = menuService.selectAllMenu();
            return JSON.toJSONString(menuList);
        }catch(Exception e){
            return "用户查找失败";
        }
    }
    @RequestMapping("/pageList")
    public String pagingMenu(HttpServletRequest request, Model model){
        menuService.showMenuByPage(request, model);
        return "view/system/menu/list";
    }
    /*
     *@Author: 杨小姣
     *@Description: 删除
     *@Date: 14:22 2019/1/23
     **/
    @RequestMapping(value="delete")
    public String deleteMenu(Long menuId){
        try{
            if(menuId!=null){
                int i = menuService.deleteByPrimaryKey(menuId);
                if (i>0){
                    System.out.println("删除成功");
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/menu/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 批量删除
     *@Date: 16:50 2019/2/26
     **/
    @RequestMapping(value="deleteAll")
    public String deleteAllMenu(String text){
        try{
            String[] menuIds = text.split(",");
            for (String menuId: menuIds) {
                menuService.deleteByPrimaryKey(Long.valueOf(menuId));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return "redirect:/menu/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 修改
     *@Date: 14:26 2019/1/23
     **/
    @RequestMapping(value="/update")
    public String update(String menuId,String menuPid,String menuName,String menuDesc ,String menuUrl){
        Long mId = Long.valueOf(menuId);
        Menu menu = menuService.selectByPrimaryKey(mId);
        menu.setMenuPid(menuPid);
        menu.setMenuName(menuName);
        menu.setMenuDesc(menuDesc);
        menu.setMenuUrl(menuUrl);
        int i = menuService.updateByPrimaryKey(menu);
        if(i>0){
            System.out.println("修改成功");
        }
        return "redirect:/menu/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 新增菜单
     *@Date: 14:38 2019/1/23
     **/
    @RequestMapping(value="/newMenu")
    public String newMenu(Menu menu){
        try{
           if(menu!=null){
               /*menu.setMenuPid("root");*/
               int i = menuService.insert(menu);
               if(i > 0){
                   System.out.println("新增菜单成功");
               }else{
                   System.out.println("新增菜单失败");
               }
           }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("新增菜单异常");
        }
        return "redirect:/menu/pageList";
    }
    /*
     *@Author: 杨小姣
     *@Description: 模糊查询
     *@Date: 17:09 2019/2/15
     **/
    @RequestMapping(value="/likeSearch")
    @ResponseBody
    public String likeSearch(String menuInput){
        try{
            List<Menu> menuList = menuService.likeQuery(menuInput);
            return JSON.toJSONString(menuList);
        }catch(Exception e){
            return "用户查找失败";
        }
    }

}
