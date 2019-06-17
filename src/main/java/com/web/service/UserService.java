package com.web.service;

import com.web.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
   public  User selectUserByName(String userName);

   List<User> selectAllUser();

   int deleteByPrimaryKey(Long userId);

   User selectByPrimaryKey(Long userId);

   int updateByPrimaryKey(User user);

   int insert(User user);

   void  showUserByPage(HttpServletRequest request, Model model);

   public List<User> likeQuery(String userInput);
}
