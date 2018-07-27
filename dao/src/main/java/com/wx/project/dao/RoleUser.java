package com.wx.project.dao;

import com.wx.project.dao.mapper.UserMapper;
import com.wx.project.dao.mapper.WxRoleMapper;
import com.wx.project.model.User;
import com.wx.project.model.WxRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ucmed
 */
@Component
public class RoleUser implements IDaoRole {
    @Autowired
    private WxRoleMapper wxRoleMapper;
    @Override
    public int insert(WxRole wxRole) throws Exception{
        return wxRoleMapper.insert(wxRole);
    }
}
