package com.web.dao;

import com.web.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface MenuDao {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Long record);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectAllMenu();

    List<Menu> queryMenuByUserId(Long userId);

    List<Menu> queryMenuSonByMenuId(Long menuId);

    List<Menu> selectAllMenu1();

    List<String> getTheUrl(String roleName);

    List<Menu>getRoleMenuByRoleId(Long roleId);
    /**
     * 使用注解方式传入多个参数
     */
    public List<Menu> selectMenuByPage(@Param(value="startPos") Integer startPos,
                                       @Param(value="pageSize") Integer pageSize);
    /**
     * 用户总数
     */
    public long getMenuCount();

    public List<Menu> likeQuery(String menuInput);
}
