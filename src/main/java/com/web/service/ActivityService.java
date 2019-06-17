package com.web.service;

import com.web.model.Activity;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface ActivityService {

    int insert(Activity record);

    int deleteByPrimaryKey(Integer activityId);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKey(Activity record);

    public void showActivityByPage(HttpServletRequest request, Model model);
}
