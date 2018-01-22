package com.stu.service;

import com.stu.entity.Cls;
import com.stu.util.PageUtil;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供班级相关业务操作的service接口
 */
public interface IClsService {

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
     * @return List<?>
     */
    public List<?> findClsList();

    /**
     * 查询班级信息
     *
     * @return List<?>
     */
    public PageUtil findClsList(PageUtil pageUtil);

    /**
     * 通过id获取班级信息
     *
     * @param id 班级id
     * @return Cls
     */
    public Cls getClsById(int id);
}
