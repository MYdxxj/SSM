package com.web.service.impl;

import com.web.dao.ActivityMapper;
import com.web.model.Activity;
import com.web.service.ActivityService;
import com.web.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ActivityServiceImpl
 * @Description TODO
 * Author 杨小姣
 * @Date 2019/2/18 15:43
 **/
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insert(Activity record) {
        return activityMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer activityId) {
        return activityMapper.deleteByPrimaryKey(activityId);
    }

    @Override
    public Activity selectByPrimaryKey(Integer activityId) {
        return activityMapper.selectByPrimaryKey(activityId);
    }

    @Override
    public int updateByPrimaryKey(Activity record) {
        return activityMapper.updateByPrimaryKey(record);
    }
    @Override
    public void showActivityByPage(HttpServletRequest request, Model model) {
        // TODO Auto-generated method stub
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Activity> activityList = new ArrayList<Activity>();
        //查询用户总数
        int totalCount = (int) activityMapper.getActivityCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            activityList = this.activityMapper.selectActivityByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            activityList = this.activityMapper.selectActivityByPage(page.getStartPos(), page.getPageSize());
        }

        model.addAttribute("activityList", activityList);
        model.addAttribute("page", page);
    }
}
