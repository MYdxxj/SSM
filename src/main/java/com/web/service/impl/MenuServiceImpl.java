package com.web.service.impl;

import com.web.dao.MenuDao;
import com.web.model.Menu;
import com.web.service.MenuService;
import com.web.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:product
 * @description:
 * @author:YangXiaoJiao
 * @create:2019-01-17 13:12
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;
    @Override
    public List<String> getTheUrl(String roleName) {
        return menuDao.getTheUrl(roleName);
    }

    @Override
    public List<Menu> selectAllMenu() {
        return menuDao.selectAllMenu();
    }

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return menuDao.deleteByPrimaryKey(menuId);
    }

    @Override
    public Menu selectByPrimaryKey(Long menuId) {
        return menuDao.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKey(Menu menu) {
        return menuDao.updateByPrimaryKey(menu );
    }

    @Override
    public int insert(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public void showMenuByPage(HttpServletRequest request, Model model) {
        // TODO Auto-generated method stub
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Menu> menuList = new ArrayList<Menu>();
        //查询用户总数
        int totalCount = (int) menuDao.getMenuCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            menuList = this.menuDao.selectMenuByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            menuList = this.menuDao.selectMenuByPage(page.getStartPos(), page.getPageSize());
        }
        model.addAttribute("menus",menuDao.selectAllMenu());
        model.addAttribute("menuList", menuList);
        model.addAttribute("page", page);
    }

    @Override
    public List<Menu> getRoleMenuByRoleId(Long roleId) {
        return menuDao.getRoleMenuByRoleId(roleId);
    }
    @Override
    public List<Menu> likeQuery(String menuInput) {
        return menuDao.likeQuery(menuInput);
    }
}
