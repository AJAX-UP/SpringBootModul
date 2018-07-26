package com.wx.project.dao.mapper;

import com.wx.project.model.Member;
import org.apache.ibatis.annotations.Param;


public interface MemberMapper {

    Member findMemberByUid(@Param("uid") Long uid) throws Exception;

    Member findMemberByMemberId(@Param("employee_id") Integer memberId) throws Exception;

}
