package com.stu.web;

import com.stu.entity.Achievement;
import com.stu.service.IAchievementService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qixuan on 2017/12/12.
 * 处理成绩相关请求的Controller类
 */

@ResponseBody
@RequestMapping("/achievementController")
@Scope("prototype")
public class AchievementController {

    @Resource(name = "achievementService")
    private IAchievementService achievementService;

    @RequestMapping("/addAchievement")
    public String addAchievement(Achievement achievement){
        return "";
    }

    public void setAchievementService(IAchievementService achievementService) {
        this.achievementService = achievementService;
    }
}
