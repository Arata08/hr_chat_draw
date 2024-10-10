package com.cx.mapper;

import com.cx.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ChenXing
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-25 15:47:20
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper {

    User login(String username, String userpwd);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    List<User> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer register(String username, String userpwd, Integer userage, String usersex);

    List<User> queryAllInfo();

    List<User> getByIName(String username);

    List<User> getOrderInfoList();

    int countTotal();
}
