package com.library.controller;

import com.library.bean.User;
import com.library.service.UserService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/pic")
public class UserController {
    @Autowired
    UserService userService;
    /*
    *
    * */
    @RequestMapping(value = "/getLabelUser",method = RequestMethod.GET)
    public Result<User> searchUser(){
        System.out.println("开始查询标图员信息");
        return ResultUtil.success(userService.serarchUser());
    }
}
