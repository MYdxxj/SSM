package com.web.dao;

import com.web.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    List<Role>getRoleNameByUserName(String userName);

    List<Role> getUserRoleByUserId(Long userId);

    public List<Role> selectRoleByPage(@Param(value="startPos") Integer startPos,
                                       @Param(value="pageSize") Integer pageSize);
    public long getRoleCount();

    public List<Role>likeQuery( String roleInput);
}
