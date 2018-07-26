package com.wx.project.dao;

import com.wx.project.dao.mapper.UserMapper;
import com.wx.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoUser implements IDaoUser {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer Id) throws Exception {
        return userMapper.selectByPrimaryKey(Id);
    }
}
