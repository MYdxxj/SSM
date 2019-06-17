package com.web.service.impl;

import com.web.dao.RoleMenuDao;
import com.web.model.RoleMenu;
import com.web.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleMenuServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/15 9:25
 **/
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Override
    public int deleteByPrimaryKey1(Long roleId) {
        return roleMenuDao.deleteByPrimaryKey1(roleId);
    }

    @Override
    public int insert(RoleMenu roleMenu) {
        return roleMenuDao.insert(roleMenu);
    }
}
