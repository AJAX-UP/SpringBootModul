package com.wx.project.dao.mapper;

import com.wx.project.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer Id);
}