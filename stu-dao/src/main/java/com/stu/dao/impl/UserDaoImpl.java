package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IUserDao;
import com.stu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qixuan on 2017/12/6.
 * 提供用户数据库相关操作的dao类
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

    @Override
    public boolean addUser(User user) {
        return addObject(user);
    }

    @Override
    public boolean updateUser(User user) {
        return updateObject(user);
    }

    @Override
    public List<?> findUserList(String hql) {
        return findObjectList(hql);
    }

    @Override
    public User getUserById(int id) {
        return (User) getObjectById(User.class, id);
    }
}
