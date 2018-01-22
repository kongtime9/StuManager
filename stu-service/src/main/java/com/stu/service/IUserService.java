package com.stu.service;

import com.stu.entity.User;

import java.util.List;

/**
 * Created by qixuan on 2017/12/6.
 * 提供用户相关业务操作的service接口
 */

public interface IUserService {

    /**
     * 处理用户登陆
     * @param user 用户对象
     * @return User
     */
    public User userLogin(User user);

    /**
     * 添加学生
     *
     * @param user 学生对象
     * @return true or false
     */
    public boolean addUser(User user);

    /**
     * 修改学生
     *
     * @param user 学生对象
     * @return true or false
     */
    public boolean updateUser(User user);

    /**
     * 查询学生信息
     *
     * @return List<?>
     */
    public List<?> findUserList();

    /**
     * 通过id获取学生信息
     *
     * @param id 学生id
     * @return User
     */
    public User getUserByIdd(int id);

}
