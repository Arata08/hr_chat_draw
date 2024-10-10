package com.cx.service;


import com.cx.domain.User;
import com.cx.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ChenXing
* @description 针对表【user】的数据库操作Service
* @createDate 2024-06-25 15:46:57
*/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册功能
     *
     * @param
     * @return
     */
    public Integer register(String username, String userpwd, Integer userage, String usersex) {
        return userMapper.register(username,userpwd,userage,usersex);
    }

    /**
     * 登录功能
     *
     * @param username
     * @param userpwd
     * @return
     */
    public User login(String username, String userpwd) {
        User resu = userMapper.login(username,userpwd);
        if(resu!=null){
            return resu;
        }return null;
    }

    /**
     * 查询所有的方法
     *
     * @return
     */
    public List<User> queryAllInfo() {
        List<User> resu = userMapper.queryAllInfo();
        return resu;
    }

    /**
     * 根据ID删除信息
     *
     * @param id
     * @return
     */
    public boolean deleteByIdInfo(Integer id) {
        return false;
    }

    /**
     * 根据ID修改信息
     *
     * @param user
     * @return
     */
    public Integer updateByIdInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据ID查询信息
     *
     * @param id
     * @return
     */
    public List<User> queryByIdInfo(Integer id) {
        return null;
    }


    public Boolean deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id) == 1;
    }

    public List<User> getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getByIName(String username) {
        return userMapper.getByIName(username);
    }

    public List<User> getOrderInfoList(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        List<User> orderInfoList = userMapper.getOrderInfoList();
        PageInfo<User> userPageInfo = new PageInfo<>(orderInfoList);
        return userPageInfo.getList();
    }

    public int countTotal() {
        return userMapper.countTotal();
    }
}
