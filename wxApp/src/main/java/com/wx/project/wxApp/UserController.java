package com.wx.project.wxApp;

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

    @RequestMapping("/user/selectUser2")
    User findMemberByMemberId() throws Exception{
        System.out.println("打印语句则没有走缓存11111111");
       return userService.selectByPrimaryKey(1);
    }
    @RequestMapping("/user/insert")
    int insert() throws Exception{
        User user=new User();
        user.setId(2);
        user.setUserName("测试事务");
        return userService.insert(user);
    }


}
