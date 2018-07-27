package com.wx.project.dao.mapper;

import com.wx.project.model.User;

/**
 * 没有主键，自动生成只能生成两个方法
 */
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer Id);
}