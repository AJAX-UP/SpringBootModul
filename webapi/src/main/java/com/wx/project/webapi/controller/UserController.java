package com.wx.project.webapi.controller;

import com.wx.project.model.User;
import com.wx.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类
 */

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/selectUser")
    User findMemberByMemberId() throws Exception{
       return userService.selectByPrimaryKey(1);
    }



}
