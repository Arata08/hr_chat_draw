package com.cx.day4.controller;

import com.cx.day4.dao.UserDao;
import com.cx.day4.dao.impl.UserDaoImpl;
import com.cx.day4.entity.User;
import com.cx.day4.service.UserServie;
import com.cx.day4.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainDemo
{

    /**
     * 登录功能
     */
    public  void  login()
    {
        Scanner  sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String userpwd = sc.next();
        UserDao userDao = new UserDaoImpl();
        UserServie userServie = new UserServiceImpl(userDao);
        int num = userServie.login(username,userpwd);
        if(num > 0)
        {
            //登录成功以后调用成功以后的菜单页面
            menu();
        }
        else
        {
            System.out.println("登录失败!");
        }
    }

    /**
     * 注册功能
     * @return
     */
    public  boolean register()
    {
        Scanner  sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String userpwd = sc.next();
        System.out.println("请输入年龄:");
        Integer userage = sc.nextInt();
        System.out.println("请输入性别:");
        String usersex = sc.next();
        User user = new User();
        user.setUsername(username);
        user.setUserpwd(userpwd);
        user.setUserage(userage);
        user.setUsersex(usersex);
        user.setIsdel(0);
        UserDao userDao = new UserDaoImpl();
        UserServie userServie = new UserServiceImpl(userDao);
        int resultnum  = userServie.register(user);
        if(resultnum > 0)
        {
            return  true;
        }
        else
        {
            return  false;
        }
    }

    public  void  menu()
    {
        for (;;)
        {
            Scanner  sc = new Scanner(System.in);
            System.out.println("---欢迎使用Xxx人事管理系统---");
            System.out.println("---1、查询所有信息---");
            System.out.println("---2、根据id删除信息---");
            System.out.println("---3、根据id修改信息---");
            System.out.println("---4、根据id查询信息---");
            System.out.println("---5、回到主菜单---");
            System.out.println("---欢迎使用Xxx人事管理系统---");
            System.out.println("请输入编号:");
            String  num = sc.next();
            UserDao userDao = new UserDaoImpl();
            UserServie userServie = new UserServiceImpl(userDao);
            if(num.equals("1"))
            {
               List<User> userList = userServie.queryAllInfo();
               if(userList != null)
               {
                   if(userList.size() > 0)
                   {
                       System.out.println("查询到的数据如下:");
                       System.out.println(userList);
                   }
                   else
                   {
                       System.out.println("没有查询到数据!");
                   }
               }
               else {
                   System.out.println("没有查询到数据!");
               }
            }
            else if(num.equals("2"))
            {
                Scanner  sc1 = new Scanner(System.in);
                System.out.println("请输入id:");
                Integer id = sc1.nextInt();
                boolean resultnum = userServie.deleteByIdInfo(id);
                if(resultnum)
                {
                    System.out.println("删除成功!");
                }
                else
                {
                    System.out.println("删除失败!");
                }
            }
            else if(num.equals("3"))
            {
                Scanner  sc1 = new Scanner(System.in);
                System.out.println("请输入id:");
                Integer id = sc1.nextInt();
                System.out.println("请输入用户名:");
                String username = sc1.next();
                System.out.println("请输入密码:");
                String userpwd = sc1.next();
                System.out.println("请输入年龄:");
                Integer userage = sc1.nextInt();
                System.out.println("请输入性别:");
                String usersex = sc1.next();
                boolean resultnum = userServie.updateByIdInfo(id,username,userpwd,userage,usersex);
                if(resultnum)
                {
                    System.out.println("修改成功!");
                }
                else
                {
                    System.out.println("修改失败!");
                }
            }
            else if(num.equals("4"))
            {
                Scanner  sc1 = new Scanner(System.in);
                System.out.println("请输入id:");
                Integer id = sc1.nextInt();
                List userlist = userServie.queryByIdInfo(id);
                if(userlist != null)
                {
                    System.out.println("查询到的数据如下:");
                    System.out.println(userlist);
                }
                else
                {
                    System.out.println("没有查询到数据!");
                }
                System.out.println("根据id查询信息");
            }
            else if(num.equals("5"))
            {
                System.out.println("回到主菜单");
                return;
            }
            else
            {
                System.out.println("输入错误,请重新输入!");
            }
        }
    }

    public static void main(String[] args)
    {
        MainDemo d = new MainDemo();
        for (;;)
        {
            Scanner  sc = new Scanner(System.in);
            System.out.println("---欢迎使用Xxx人事管理系统---");
            System.out.println("---1、注册---");
            System.out.println("---2、登录---");
            System.out.println("---3、退出系统---");
            System.out.println("---欢迎使用Xxx人事管理系统---");
            System.out.println("请输入编号:");
            String  num = sc.next();
            if(num.equals("1"))
            {
                if(d.register())
                {
                    System.out.println("注册成功!");
                }
                else
                {
                    System.out.println("注册失败!");
                }
            }
            else if(num.equals("2"))
            {
                d.login();
            }
            else if(num.equals("3"))
            {
                System.out.println("退出系统!");
                return;
            }
            else
            {
                System.out.println("输入错误,请重新输入!");
            }
        }

    }
}
