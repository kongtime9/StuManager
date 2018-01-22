package com.stu.service.impl;

import com.stu.dao.IClsDao;
import com.stu.entity.Cls;
import com.stu.service.IClsService;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2017/12/6.
 * 提供班级相关业务操作的service类
 */

@Service("clsService")
public class ClsServiceImpl implements IClsService {

    /**
     * 引入dao层依赖
     */
    @Resource(name = "clsDao")
    private IClsDao clsDao;

    @Override
    public boolean addCls(Cls cls) {
        return clsDao.addCls(cls);
    }

    @Override
    public boolean updateCls(Cls cls) {
        return clsDao.updateCls(cls);
    }

    @Override
    public List<?> findClsList() {
        String hql = "from Cls c";
        return clsDao.findClsList(hql);
    }

    @Override
    public PageUtil findClsList(PageUtil pageUtil) {
        String hql = "from Cls c order by c.cno asc";
        return clsDao.findClsList(hql, pageUtil);
    }

    @Override
    public Cls getClsById(int id) {
        return clsDao.getClsById(id);
    }

    public void setClsDao(IClsDao clsDao) {
        this.clsDao = clsDao;
    }
}
