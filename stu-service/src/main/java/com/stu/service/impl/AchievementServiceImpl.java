package com.stu.service.impl;

import com.stu.dao.IAchievementDao;
import com.stu.entity.Achievement;
import com.stu.service.IAchievementService;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2017/12/6.
 * 提供成绩相关业务操作的service类
 */

@Service("achievementService")
public class AchievementServiceImpl implements IAchievementService {

    /**
     * 引入dao层依赖
     */
    @Resource(name = "achievementDao")
    private IAchievementDao achievementDao;

    @Override
    public boolean addAchievement(Achievement achievement) {
        return achievementDao.addAchievement(achievement);
    }

    @Override
    public boolean updateAchievement(Achievement achievement) {
        return achievementDao.updateAchievement(achievement);
    }

    @Override
    public List<?> findAchievementList() {
        String hql = "from Achievement a";
        return achievementDao.findAchievementList(hql);
    }

    @Override
    public PageUtil findAchievementList(PageUtil pageUtil) {
        String hql = "from Achievement a";
        return achievementDao.findAchievementList(hql, pageUtil);
    }

    @Override
    public Achievement getAchievementById(int id) {
        return achievementDao.getAchievementById(id);
    }

    public void setAchievementDao(IAchievementDao achievementDao) {
        this.achievementDao = achievementDao;
    }
}
