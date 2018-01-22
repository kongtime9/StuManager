package com.stu.dao;

import com.stu.util.PageUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qixuan on 2017/11/19.
 * 数据库操作的工具类
 */

@Repository
public class BaseDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 添加对象的方法
     *
     * @param obj 对象
     * @return true or false
     */
    public boolean addObject(Object obj) {
        try {
            getSession().save(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改对象的方法
     *
     * @param obj 对象
     * @return true or false
     */
    public boolean updateObject(Object obj) {
        try {
            getSession().update(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除对象的方法
     *
     * @param obj 对象
     * @return true or false
     */
    public boolean deleteObject(Object obj) {
        try {
            getSession().delete(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询对象
     *
     * @param hql 查询语句
     * @return 对象集合
     */
    public List<Object> findObjectList(String hql) {
        try {
            return getSession().createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询对象
     * 分页查询
     * @param hql 查询语句
     * @return 对象集合
     */
    public PageUtil findObjectList(String hql, PageUtil pageUtil) {
        try {
            Query query = getSession().createQuery(hql);
            query.setFirstResult((pageUtil.getPage()-1)*pageUtil.getLimit());
            query.setMaxResults(pageUtil.getLimit());
            pageUtil.setData(query.list());
            return pageUtil;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过对象id获取对象
     *
     * @param cls 对象的原型
     * @param id  对象id
     * @return 对象
     */
    public Object getObjectById(Class cls, int id) {
        try {
            return getSession().get(cls, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取总条数
     * @param hql 统计的hql语句
     * @return Integer
     */
    public Integer getTotal(String hql){
        try {
            Integer i = Math.toIntExact((Long) getSession().createQuery(hql).list().get(0));
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
