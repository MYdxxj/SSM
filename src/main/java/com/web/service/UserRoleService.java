package com.web.service;

import com.web.model.Role;
import com.web.model.UserRole;

import java.util.List;

public interface UserRoleService {
    int insert(UserRole userRole);
    int deleteByPrimaryKey1(Long userId);
}
