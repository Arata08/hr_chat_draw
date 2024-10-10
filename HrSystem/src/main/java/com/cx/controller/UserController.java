package com.cx.controller;

import com.cx.Utils.Page;
import com.cx.domain.User;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author ChenXing
 * 2024/6/25 下午2:02
 * describe：员工管理
 */
@RestController()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Integer getUser(@RequestParam String username,@RequestParam String userpwd){
        if(userService.login(username,userpwd)==null){
            return 0;
        }else {
            return 1;
        }
    }

    @PostMapping(value = "/register")
    public Integer register(String username, String userpwd, Integer userage, String usersex){
        if(userService.login(username,userpwd)==null){
            userService.register(username,userpwd,userage,usersex);
            return 1;
        }else {
            return 0;
        }
    }

    @PostMapping(value = "/queryAll")
    public List<User> queryAll(){
        return userService.queryAllInfo();
    }

    @PostMapping(value = "/updateById")
    public Integer queryById(Integer id, String username, String userpwd, Integer userage, String usersex, Integer isdel){
        User user = new User(id,username,userpwd,userage,usersex,isdel);
        System.out.println("user = " + user);
        return userService.updateByIdInfo(user);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Boolean deleteById(Integer id){
        return userService.deleteById(id);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public List<User> getById(@RequestParam(value="id") Integer id){
        return userService.getById(id);
    }

    @RequestMapping(value = "/getByname",method = RequestMethod.POST)
    public  List<User> getByName(@RequestParam("value")String username){
        return userService.getByIName(username);
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public Page<User> getUserList(@RequestParam(value = "pageNow",defaultValue = "1") int pageNow,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        int total = userService.countTotal();
        List<User> userList=userService.getOrderInfoList(pageNow, pageSize);
        return new Page<>(pageNow, total, pageSize, userList);
    }
}
