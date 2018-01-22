package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IAchievementDao;
import com.stu.entity.Achievement;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供成绩数据库相关操作的dao类
 */

@Repository("achievementDao")
public class AchievementDaoImpl extends BaseDao implements IAchievementDao {

    @Override
    public boolean addAchievement(Achievement achievement) {
        return addObject(achievement);
    }

    @Override
    public boolean updateAchievement(Achievement achievement) {
        return updateObject(achievement);
    }

    @Override
    public List<?> findAchievementList(String hql) {
        return findObjectList(hql);
    }

    @Override
    public PageUtil findAchievementList(String hql, PageUtil pageUtil) {
        pageUtil.setCount(getTotal("select count(*) " + hql));
        return findObjectList(hql, pageUtil);
    }

    @Override
    public Achievement getAchievementById(int id) {
        return (Achievement) getObjectById(Achievement.class, id);
    }
}
