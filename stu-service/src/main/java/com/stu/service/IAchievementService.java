package com.stu.service;

import com.stu.entity.Achievement;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供成绩相关业务操作的service接口
 */
public interface IAchievementService {

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
     * @return List<?>
     */
    public List<?> findAchievementList();

    /**
     * 查询成绩信息
     *
     * @return List<?>
     */
    public PageUtil findAchievementList(PageUtil pageUtil);

    /**
     * 根据成绩id获取成绩信息
     *
     * @param id 成绩id
     * @return Achievement
     */
    public Achievement getAchievementById(int id);
}
