package com.cx.day4.service;

import com.cx.day4.entity.User;
import java.util.List;

public interface UserServie
{
    /**
     * 注册功能
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录功能
     * @param username
     * @param userpwd
     * @return
     */
    int  login(String username, String userpwd);

    /**
     * 查询所有的方法
     * @return
     */
    List<User> queryAllInfo();

    /**
     * 根据ID删除信息
     * @param id
     * @return
     */
    boolean  deleteByIdInfo(Integer id);

    /**
     * 根据ID修改信息
     * @param id
     * @return
     */
    boolean  updateByIdInfo(Integer id, String username, String userpwd, Integer userage, String usersex);

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    List<User>  queryByIdInfo(Integer id);

}
