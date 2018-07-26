package com.wx.project.dao;

import com.wx.project.model.User;

/**
 * Created by luyh on 16/4/27.
 */
public interface IDaoUser {

    User selectByPrimaryKey(Integer Id) throws Exception;

}
