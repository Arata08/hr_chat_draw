package com.cx.day4.dao;

import com.cx.day4.entity.User;

import java.sql.SQLException;
import java.util.List;
public interface UserDao
{
    /**
     * 注册功能
     * @param user
     * @return
     */
    public int register(User user);

    /**
     * 登录功能
     * @param username
     * @param userpwd
     * @return
     */
    public int  login(String username,String userpwd);

    /**
     * 查询所有的方法
     * @return
     */
    public List<User>  queryAllInfo();

    /**
     * 根据ID删除信息
     * @param id
     * @return
     */
    public boolean  deleteByIdInfo(Integer id);

    /**
     * 根据ID修改信息
     * @param id
     * @return
     */
    public boolean  updateByIdInfo(Integer id,String username,String userpwd,Integer userage,String usersex);

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    public List<User>  queryByIdInfo(Integer id);

}
