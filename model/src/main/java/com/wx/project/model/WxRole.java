package com.wx.project.model;

import java.io.Serializable;

public class WxRole implements Serializable {

    private static final long serialVersionUID = -1959528436584592183L;

    private Integer id;

    private Integer userId;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}