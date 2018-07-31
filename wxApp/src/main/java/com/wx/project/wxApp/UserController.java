package com.wx.project.wxApp;

import com.wx.project.model.User;
import com.wx.project.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类
 */
@Api(value="用户controller",tags={"用户接口1"})
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/selectUser2", method = RequestMethod.GET)
    User findMemberByMemberId() throws Exception{
        System.out.println("打印语句则没有走缓存11111111");
       return userService.selectByPrimaryKey(1);
    }
    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    int insert() throws Exception{
        User user=new User();
        user.setId(2);
        user.setUserName("测试事务");
        return userService.insert(user);
    }


}
