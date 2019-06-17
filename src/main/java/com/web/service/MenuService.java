package com.web.service;

import com.web.model.Menu;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenuService {
    public List<String> getTheUrl(String roleName);

    List<Menu> selectAllMenu();

    int deleteByPrimaryKey(Long menuId);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKey(Menu menu);

    int insert(Menu menu);

    void  showMenuByPage(HttpServletRequest request, Model model);

    List<Menu>getRoleMenuByRoleId(Long roleId);

    public List<Menu> likeQuery(String menuInput);
}
