package com.wx.project.service;

import com.wx.project.model.User;

/**
 *
 */
public interface IUserService {

    User selectByPrimaryKey(Integer Id) throws Exception;

    int insert(User user) throws Exception;

}
