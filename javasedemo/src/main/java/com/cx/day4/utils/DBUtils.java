package com.cx.day4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils
{
    private  final  static  String Driver = "com.mysql.jdbc.Driver";
    private  final  static  String URL = "jdbc:mysql://47.106.182.219:3306/cx";
    private  final  static  String USERNAME = "cx";
    private  final  static  String UPWD = "pZzXkfnj8jXz4ami";

    public static Connection getConnection()
    {
        Connection con = null;
        try {
            //加载驱动
            Class.forName(Driver);
            //获取数据库的链接对象
            con = DriverManager.getConnection(URL,USERNAME,UPWD);
            return  con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  con;
    }


}
