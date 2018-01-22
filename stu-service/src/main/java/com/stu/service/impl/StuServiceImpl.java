package com.stu.service.impl;

import com.stu.dao.IStuDao;
import com.stu.entity.Stu;
import com.stu.service.IStuService;
import com.stu.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2017/12/6.
 * 提供学生相关业务操作的service类
 */

@Service("stuService")
public class StuServiceImpl implements IStuService {

    /**
     * 引入dao层依赖
     */
    @Resource(name = "stuDao")
    private IStuDao stuDao;

    @Override
    public boolean addStu(Stu stu) {
        return stuDao.addStu(stu);
    }

    @Override
    public boolean updateStu(Stu stu) {
        return stuDao.updateStu(stu);
    }

    @Override
    public List<?> findStuList() {
        String hql = "from Stu s";
        return stuDao.findStuList(hql);
    }

    @Override
    public boolean deleteStu(Stu stu) {
        return stuDao.deleteStu(stu);
    }

    @Override
    public PageUtil findStuList(PageUtil pageUtil) {
        String hql = "from Stu s left join s.cls c ";
        if(pageUtil.getKeyword() != null){
            hql += " where s.sname like '%" + pageUtil.getKeyword() + "%' or s.sno like '%" + pageUtil.getKeyword() + "%' or c.cname like '%" + pageUtil.getKeyword() + "%' ";
        }
        hql += " order by c.cno";
        return stuDao.findStuList(hql, pageUtil);
    }

    @Override
    public Stu getStuByIdd(int id) {
        return null;
    }

    public void setStuDao(IStuDao stuDao) {
        this.stuDao = stuDao;
    }
}
