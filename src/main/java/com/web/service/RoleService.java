package com.web.service;

import com.web.model.Menu;
import com.web.model.Role;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RoleService {
    List<Role>getRoleNameByUserName(String userName);

    List<Role> selectAllRole();

    int deleteByPrimaryKey(Long roleId);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKey(Role role);

    int insert(Role role);

    List<Role> getUserRoleByUserId(Long userId);

    void  showRoleByPage(HttpServletRequest request, Model model);

    public List<Role>likeQuery( String roleInput);
}
