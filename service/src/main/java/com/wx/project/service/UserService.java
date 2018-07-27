package com.wx.project.service;

import com.wx.project.dao.IDaoRole;
import com.wx.project.dao.IDaoUser;
import com.wx.project.dao.redisConfig.RedisUtil;
import com.wx.project.model.User;
import com.wx.project.model.WxRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService{

    @Autowired
    private IDaoUser daoUser;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IDaoRole daoRole;

    @Override
    @Cacheable(value="findAllUser",key="1")
    public User selectByPrimaryKey(Integer Id) throws Exception {
       /* Map m=new HashMap<>();
        m.put("1","121312");
        m.put("2","121312");
        redisUtil.setMap("123456",m);*/
        System.out.println("打印语句则没有走缓存");
        return daoUser.selectByPrimaryKey(Id);
    }
    @Override
    @Transactional
    public int insert(User user) throws Exception{
        WxRole role=new WxRole();
        role.setId(1);
        role.setRoleName("测试事务");
        daoRole.insert(role);
        return daoUser.insert(user);
    }

}
