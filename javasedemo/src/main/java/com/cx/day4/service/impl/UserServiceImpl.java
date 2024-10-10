package com.cx.day4.service.impl;

import com.cx.day4.dao.UserDao;
import com.cx.day4.entity.User;
import com.cx.day4.service.UserServie;

import java.util.List;

public class UserServiceImpl implements UserServie
{

    private UserDao userDao;

    public  UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public int register(User user) {
        return  userDao.register(user);
    }

    @Override
    public int login(String username, String userpwd) {
        return userDao.login(username,userpwd);
    }

    @Override
    public List<User> queryAllInfo() {
        return userDao.queryAllInfo();
    }

    @Override
    public boolean deleteByIdInfo(Integer id) {
        return userDao.deleteByIdInfo(id);
    }

    @Override
    public boolean updateByIdInfo(Integer id,String username,String userpwd,Integer userage,String usersex) {
        return userDao.updateByIdInfo(id,username,userpwd,userage,usersex);
    }

    @Override
    public List<User> queryByIdInfo(Integer id) {
        return userDao.queryByIdInfo(id);
    }
}
