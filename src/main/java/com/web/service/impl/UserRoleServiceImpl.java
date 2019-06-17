package com.web.service.impl;

import com.web.dao.UserRoleDao;
import com.web.model.Role;
import com.web.model.UserRole;
import com.web.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:product
 * @description:
 * @author:YangXiaoJiao
 * @create:2019-01-24 18:06
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public int insert(UserRole userRole) {
        return userRoleDao.insert(userRole);
    }

    @Override
    public int deleteByPrimaryKey1(Long userId) {
        return userRoleDao.deleteByPrimaryKey1(userId);
    }

}
