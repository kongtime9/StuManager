package com.stu.dao;

import com.stu.entity.Stu;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/6.
 * 提供学生数据库相关操作的dao接口
 */

public interface IStuDao {

    /**
     * 添加学生
     *
     * @param stu 学生对象
     * @return true or false
     */
    public boolean addStu(Stu stu);

    /**
     * 修改学生
     *
     * @param stu 学生对象
     * @return true or false
     */
    public boolean updateStu(Stu stu);

    /**
     * 查询学生信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public List<?> findStuList(String hql);

    /**
     * 查询学生信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public PageUtil findStuList(String hql, PageUtil pageUtil);

    /**
     * 通过id获取学生信息
     *
     * @param id 学生id
     * @return Stu
     */
    public Stu getStuById(int id);


    /**
     * 刪除的學生的方法
     * @param stu
     * @return
     */
    public boolean deleteStu(Stu stu);

}
