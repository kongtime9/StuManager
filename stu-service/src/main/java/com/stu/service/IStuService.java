package com.stu.service;

import com.stu.entity.Stu;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/6.
 * 提供学生相关业务操作的service接口
 */

public interface IStuService {

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
     * @return List<?>
     */
    public List<?> findStuList();

    /**
     * 删除学生的方法
     * @param stu 学生对象
     * @return true or false
     */
    public boolean deleteStu(Stu stu);


    /**
     * 查询学生信息
     *
     * @return List<?>
     */
    public PageUtil findStuList(PageUtil pageUtil);

    /**
     * 通过id获取学生信息
     *
     * @param id 学生id
     * @return Stu
     */
    public Stu getStuByIdd(int id);

}
