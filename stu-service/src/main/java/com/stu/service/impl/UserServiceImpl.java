package com.stu.service.impl;

import com.stu.dao.IUserDao;
import com.stu.entity.User;
import com.stu.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2017/12/6.
 * 提供用户相关业务操作的service类
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    /**
     * 引入dao层依赖
     */
    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public User userLogin(User user) {
        String hql = "from User u where u.uname='" + user.getUname() + "' and u.ustatus = 1";
        List<User> uList = (List<User>) userDao.findUserList(hql);
        for (User u : uList) {
            if(u.getUname().equals(user.getUname()) && u.getUpwd().equals(user.getUpwd())){
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public List<?> findUserList() {
        return null;
    }

    @Override
    public User getUserByIdd(int id) {
        return null;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
