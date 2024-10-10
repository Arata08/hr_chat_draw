package com.cx.day4.dao.impl;

import com.cx.day4.dao.UserDao;
import com.cx.day4.entity.User;
import com.cx.day4.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao
{

    @Override
    public int register(User user) {
        //链接数据库
        Connection con = DBUtils.getConnection();
        try {
            if(con != null)
            {
                String sql = "insert into user(username,userpwd,userage,usersex,isdel) " +
                        " values(?,?,?,?,?)";
               PreparedStatement pstmt = con.prepareStatement(sql);
               //分别给5个问号传递数据值
                pstmt.setString(1,user.getUsername());
                pstmt.setString(2,user.getUserpwd());
                pstmt.setInt(3,user.getUserage());
                pstmt.setString(4,user.getUsersex());
                pstmt.setInt(5,0);
               int num = pstmt.executeUpdate();
               return  num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    @Override
    public int login(String username, String userpwd) {
        Connection con = DBUtils.getConnection();
        try {
            if(con != null)
            {
                String sql = "select username,userpwd from user where username=? and userpwd=?";
                final PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1,username);
                pstmt.setString(2,userpwd);
                final ResultSet rs = pstmt.executeQuery();
                if(rs.next())
                {
                    return  1;
                }
                else
                {
                    return  0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    @Override
    public List<User> queryAllInfo() {

        ArrayList<User> userList = null;
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from user";
            final PreparedStatement pstmt = con.prepareStatement(sql);
            final ResultSet rs = pstmt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next())
            {
                userList.add(new User(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getString(5),rs.getInt(6)));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteByIdInfo(Integer id){
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from user where id=?");
            ps.setInt(1,id);
            if(ps.executeUpdate()==0){
                return false;
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateByIdInfo(Integer id,String username,String userpwd,Integer userage,String usersex) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("update user set username=?,userpwd=?,userage=?,usersex=? where id=?");
            ps.setString(1,username);
            ps.setString(2,userpwd);
            ps.setInt(3,userage);
            ps.setString(4,usersex);
            ps.setInt(5,id);
            if(ps.executeUpdate()==0){
                return false;
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public List<User> queryByIdInfo(Integer id) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from user where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()){
                list.add(new User(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getString(5),rs.getInt(6)));
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
