package com.cx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author ChenXing
 * 2024/6/25 下午1:58
 * describe：测试
 */
@Controller
@RequestMapping("param")
public class ParamController {
    //后端直接接收
    //  /param/data?name=root&age=18
    //  形参列表,填写对应名称的参数即可!  请求参数名 = 形参参数名即可!
    //  1. 名称相同  2.可以不传递 不报错
    @RequestMapping("data")
    @ResponseBody
    public String data(String name,Integer age){
        System.out.println("接收到：name = " + name + ", age = " + age);
        return "成功给前端返回：name = " + name + ", age = " + age;
    }
}