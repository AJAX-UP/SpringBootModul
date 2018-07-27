package com.wx.project.dao.mapper;

import com.wx.project.model.WxRole;

public interface WxRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxRole record);

    int insertSelective(WxRole record);

    WxRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxRole record);

    int updateByPrimaryKey(WxRole record);
}