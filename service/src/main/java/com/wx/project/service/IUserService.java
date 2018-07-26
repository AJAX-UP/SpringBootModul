package com.wx.project.service;

import com.wx.project.model.User;

/**
 * Created by luyh on 16/4/27.
 */
public interface IUserService {

    User selectByPrimaryKey(Integer Id) throws Exception;

}
