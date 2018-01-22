package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IStuDao;
import com.stu.entity.Stu;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qixuan on 2017/12/6.
 * 提供学生数据库相关操作的dao类
 */

@Repository("stuDao")
public class StuDaoImpl extends BaseDao implements IStuDao {

    @Override
    public boolean addStu(Stu stu) {
        return addObject(stu);
    }

    @Override
    public boolean updateStu(Stu stu) {
        return updateObject(stu);
    }

    @Override
    public boolean deleteStu(Stu stu) {
        return deleteObject(stu);
    }

    @Override
    public List<?> findStuList(String hql) {
        return findObjectList(hql);
    }

    @Override
    public PageUtil findStuList(String hql, PageUtil pageUtil) {
        pageUtil.setCount(getTotal("select count(*) " + hql));
        return findObjectList(hql, pageUtil);
    }

    @Override
    public Stu getStuById(int id) {
        return (Stu) getObjectById(Stu.class, id);
    }


}
