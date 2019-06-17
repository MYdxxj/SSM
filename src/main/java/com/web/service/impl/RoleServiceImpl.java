package com.web.service.impl;

import com.web.dao.RoleDao;
import com.web.model.Role;
import com.web.service.RoleService;
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
 * @create:2019-01-17 13:14
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    @Override
    public List<Role>getRoleNameByUserName(String userName) {
        return roleDao.getRoleNameByUserName(userName);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleDao.selectAllRole();
    }

    @Override
    public int deleteByPrimaryKey(Long roleId) {
        return roleDao.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role selectByPrimaryKey(Long roleId) {
        return roleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKey(Role role) {
        return roleDao.updateByPrimaryKey(role);
    }

    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public List<Role> getUserRoleByUserId(Long userId) {
        return roleDao.getUserRoleByUserId(userId);
    }

    @Override
    public void showRoleByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Role> RoleList = new ArrayList<Role>();
        //查询用户总数
        int totalCount = (int) roleDao.getRoleCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            RoleList = this.roleDao.selectRoleByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            RoleList = this.roleDao.selectRoleByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("roleList", RoleList);
        model.addAttribute("page", page);
    }

    @Override
    public List<Role> likeQuery(String roleInput) {
        return roleDao.likeQuery(roleInput);
    }

}
