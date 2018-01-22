package com.stu.dao;

import com.stu.entity.Cls;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供班级数据库相关操作的dao接口
 */
public interface IClsDao {

    /**
     * 添加班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean addCls(Cls cls);

    /**
     * 修改班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean updateCls(Cls cls);

    /**
     * 查询班级信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public List<?> findClsList(String hql);

    /**
     * 查询班级信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public PageUtil findClsList(String hql, PageUtil pageUtil);

    /**
     * 通过id获取班级信息
     *
     * @param id 班级id
     * @return Cls
     */
    public Cls getClsById(int id);
}
