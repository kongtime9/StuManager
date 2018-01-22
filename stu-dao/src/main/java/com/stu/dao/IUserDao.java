package com.stu.dao;

import com.stu.entity.User;

import java.util.List;

/**
 * Created by LARK on 2017/12/12.
 * 提供用户数据库相关操作的dao接口
 */

public interface IUserDao {

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return true or false
     */
    public boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return true or false
     */
    public boolean updateUser(User user);

    /**
     * 查询用户信息
     *
     * @param hql 查询的hql语句
     * @return List<?>
     */
    public List<?> findUserList(String hql);

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return User
     */
    public User getUserById(int id);
}
