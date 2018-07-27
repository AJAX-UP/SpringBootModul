package com.wx.project.service;

import com.wx.project.dao.IDaoRole;
import com.wx.project.dao.IDaoUser;
import com.wx.project.model.User;
import com.wx.project.model.WxRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IDaoUser daoUser;

    @Autowired
    private IDaoRole daoRole;

    @Override
    public User selectByPrimaryKey(Integer Id) throws Exception {
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
