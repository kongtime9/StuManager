package com.stu.dao;

import com.stu.entity.Achievement;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供成绩数据库相关操作的dao接口
 */
public interface IAchievementDao {

    /**
     * 添加成绩
     *
     * @param achievement 成绩对象
     * @return true or false
     */
    public boolean addAchievement(Achievement achievement);

    /**
     * 修改成绩
     *
     * @param achievement 成绩对象
     * @return true or false
     */
    public boolean updateAchievement(Achievement achievement);

    /**
     * 查询成绩信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public List<?> findAchievementList(String hql);

    /**
     * 查询成绩信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public PageUtil findAchievementList(String hql, PageUtil pageUtil);

    /**
     * 根据成绩id获取成绩信息
     *
     * @param id 成绩id
     * @return Achievement
     */
    public Achievement getAchievementById(int id);
}
