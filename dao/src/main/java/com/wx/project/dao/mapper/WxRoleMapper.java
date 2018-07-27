package com.wx.project.dao.mapper;

import com.wx.project.model.WxRole;

public interface WxRoleMapper {
    int insert(WxRole record);

    int insertSelective(WxRole record);
}