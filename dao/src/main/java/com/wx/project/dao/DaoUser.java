package com.wx.project.dao;

import com.wx.project.dao.mapper.UserMapper;
import com.wx.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ucmed on 2018/7/26.
 */
public class DaoUser implements IDaoUser {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer Id) throws Exception {
        return userMapper.selectByPrimaryKey(Id);
    }
}
