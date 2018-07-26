package com.wx.project.dao;

import com.wx.project.model.User;

public interface IDaoUser {

    User selectByPrimaryKey(Integer Id) throws Exception;

}
