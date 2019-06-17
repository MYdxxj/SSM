package com.web.dao;

import com.web.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User user);

    User queryToLogin(User user);

    List<User> selectAllUser();

    User queryUserByAccountAndPassword(User user);

    User getUserByUserId(Long userId);

    List<User> queryAllUser();

    List<User> selectUser();

    User selectUserByName(String userName);

    /**
     * 使用注解方式传入多个参数
     */
    public List<User> selectUserByPage(@Param(value = "startPos") Integer startPos,
                                       @Param(value = "pageSize") Integer pageSize);

    /**
     * 用户总数
     */
    public long getUserCount();
    public List<User> likeQuery(String userInput);
}
