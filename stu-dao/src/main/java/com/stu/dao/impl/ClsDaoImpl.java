package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IClsDao;
import com.stu.entity.Cls;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qixuan on 2017/12/12.
 * 提供班级数据库相关操作的dao类
 */

@Repository("clsDao")
public class ClsDaoImpl extends BaseDao implements IClsDao {

    @Override
    public boolean addCls(Cls cls) {
        return addObject(cls);
    }

    @Override
    public boolean updateCls(Cls cls) {
        return updateObject(cls);
    }

    @Override
    public List<?> findClsList(String hql) {
        return findObjectList(hql);
    }

    @Override
    public PageUtil findClsList(String hql, PageUtil pageUtil){
        pageUtil.setCount(getTotal("select count(c.cno) " + hql));
        return findObjectList(hql, pageUtil);
    }

    @Override
    public Cls getClsById(int id) {
        return (Cls) getObjectById(Cls.class, id);
    }

}
