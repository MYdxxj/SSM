package com.web.dao;

import com.web.model.RoleMenu;

public interface RoleMenuDao {
  /*  int deleteByPrimaryKey(Long roleMenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Long roleMenuId);

    int updateByPrimaryKeySelective(RoleMenu roleMenu);

    int updateByPrimaryKey(RoleMenu roleMenu);

    int deleteByRoleMenu(RoleMenu rolemenu);

    int deleteByPrimaryKey1(Long roleId);*/

    int insert(RoleMenu roleMenu);

    int deleteByPrimaryKey1(Long roleId);
}
