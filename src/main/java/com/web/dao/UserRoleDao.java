package com.web.dao;

import com.web.model.Role;
import com.web.model.UserRole;

import java.util.List;

public interface UserRoleDao {

    int deleteByPrimaryKey(String userRoleId);
    int deleteByPrimaryKey1(Long userId);
    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int deleteByUserRole(UserRole uerfrole);

    List<Role> getUserRoleByUserId(Long userId);


}
