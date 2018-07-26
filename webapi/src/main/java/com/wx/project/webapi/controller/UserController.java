package com.wx.project.webapi.controller;

import com.wx.project.model.Member;
import com.wx.project.model.User;
import com.wx.project.service.IMemberService;
import com.wx.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luyh on 16/4/27.
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
